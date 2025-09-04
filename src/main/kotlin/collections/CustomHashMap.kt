package collections

import kotlin.apply
import kotlin.math.abs

class CustomHashMap<K, V> : CustomMutableMap<K, V> {

    var elements = arrayOfNulls<Node<K, V>>(INITIAL_CAPACITY)
    override var size: Int = 0
        private set

    private var modCount = 0

    override val keys: CustomSet<K>
        get() = CustomHashSet<K>().apply {
            foreEach {
                add(it.key)
            }
        }
    override val values: CustomCollection<V>
        get() = CustomArrayList<V>().apply {
            foreEach {
                add(it.value)
            }
        }

    override fun get(key: K): V? {
        val position = getElementPosition(key, elements.size)
        var existedElement = elements[position]
        while (existedElement != null) {
            if (existedElement.key == key) {
                return existedElement.value
            } else {
                existedElement = existedElement.next
            }
        }
        return null
    }

    override fun containsKey(key: K): Boolean {
        val position = getElementPosition(key, elements.size)
        var existedElement = elements[position]
        while (existedElement != null) {
            if (existedElement.key == key) {
                return true
            } else {
                existedElement = existedElement.next
            }
        }
        return false
    }

    override fun containsValue(value: V): Boolean {
        foreEach {
            if (it.value == value) return true
        }
        return false
    }

    override fun put(key: K, value: V): V? {
        increaseSize()
        modCount++
        return put(key, value, elements).also { if (it == null) size++ }
    }

    override fun remove(key: K): V? {
        modCount++
        val position = getElementPosition(key, elements.size)
        val existedElement = elements[position] ?: return null
        if (existedElement.key == key) {
            elements[position] = existedElement.next
            size--
            return existedElement.value
        }
        var before: Node<K, V>? = existedElement
        while (before?.next != null) {
            val removingElement = before.next
            if (removingElement?.key == key) {
                before.next = removingElement.next
                size--
                return removingElement.value
            } else {
                before = before.next
            }
        }
        return null
    }

    override fun clear() {
        modCount++
        elements = arrayOfNulls<Node<K, V>>(INITIAL_CAPACITY)
        size = 0
    }

    fun keyIterator(): MutableIterator<K> {
        return object : MutableIterator<K> {

            private var nodeIndex = 0
            private var nextNode = elements[nodeIndex]
            private var nextIndex = 0
            private val currentModCount = modCount

            override fun hasNext(): Boolean {
                return nextIndex < size
            }

            override fun next(): K {
                if (modCount != currentModCount) throw ConcurrentModificationException()
                while (nextNode == null) {
                    nextNode = elements[++nodeIndex]
                }
                return nextNode?.key!!.also {
                    nextIndex++
                    nextNode = nextNode?.next
                }
            }

            override fun remove() {

            }
        }
    }

    private inline fun foreEach(operation: (Node<K, V>) -> Unit) {
        elements.forEach { node ->
            var current = node
            while (current != null) {
                operation(current)
                current = current.next
            }
        }
    }

    private fun increaseSize() {
        if (size.toFloat() / elements.size >= LOAD_FACTOR) {
            val newArray = arrayOfNulls<Node<K, V>>(elements.size * 2)
            elements.forEach {
                var currentElement = it
                while (currentElement != null) {
                    put(currentElement.key, currentElement.value, newArray)
                    currentElement = currentElement.next
                }
            }
            elements = newArray
        }
    }

    private fun put(key: K, value: V, array: Array<Node<K, V>?>): V? {
        val newNode = Node(key, value)
        val nodePosition = getElementPosition(key, array.size)
        var existedNode = array[nodePosition]
        if (existedNode == null) {
            array[nodePosition] = newNode
            return null
        } else {
            while (true) {
                if (existedNode?.key == key) {
                    return existedNode.value.also {
                        existedNode.value = value
                    }
                } else {
                    if (existedNode?.next == null) {
                        existedNode?.next = newNode
                        return null
                    } else {
                        existedNode = existedNode.next
                    }
                }
            }
        }
    }

    private fun getElementPosition(key: K, arraySize: Int): Int {
        return abs(key.hashCode() % arraySize)
    }

    data class Node<K, V>(
        val key: K,
        var value: V,
        var next: Node<K, V>? = null,
    )

    companion object {
        private const val INITIAL_CAPACITY = 16
        private const val LOAD_FACTOR = 0.75
    }

}