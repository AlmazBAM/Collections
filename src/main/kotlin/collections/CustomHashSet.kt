package collections

import kotlin.math.abs

class CustomHashSet<T> : CustomMutableSet<T> {

    var elements = arrayOfNulls<Node<T>>(INITIAL_CAPACITY)
    override var size: Int = 0
        private set

    override fun contains(element: T): Boolean {
        val position = getElementPosition(element, elements.size)
        var existedElement = elements[position]
        while (existedElement != null) {
            if (existedElement.item == element) {
                return true
            } else {
                existedElement = existedElement.next
            }
        }
        return false
    }

    override fun add(element: T): Boolean {
        increaseSize()
        return add(element, elements).also { if (it) size++ }
    }

    override fun remove(element: T) {
        val position = getElementPosition(element, elements.size)
        val existedElement = elements[position] ?: return
        if (existedElement.item == element) {
            val after = existedElement.next
            if (after == null)
                elements[position] = null
            else
                elements[position] = after
            size--
            return
        }
        var before: Node<T>? = existedElement
        while (before?.next != null) {
            val current = before.next
            if (current?.item == element) {
                val after = current.next
                before.next = after
                size--
                return
            } else {
                before = before.next
            }
        }
    }

    override fun clear() {
        elements = arrayOfNulls<Node<T>>(INITIAL_CAPACITY)
        size = 0
    }

    private fun increaseSize() {
        if (size.toFloat() / elements.size >= LOAD_FACTOR) {
            val newArray = arrayOfNulls<Node<T>>(elements.size * 2)
            elements.forEach {
                var currentElement = it
                while (currentElement != null) {
                    add(currentElement.item, newArray)
                    currentElement = currentElement.next
                }
            }
            elements = newArray
        }
    }

    private fun add(element: T, array: Array<Node<T>?>): Boolean {
        val newNode = Node(element)
        val nodePosition = getElementPosition(element, array.size)
        var existedNode = array[nodePosition]
        if (existedNode == null) {
            array[nodePosition] = newNode
            return true
        } else {
            while (true) {
                if (existedNode?.item == element) {
                    return false
                } else {
                    if (existedNode?.next == null) {
                        existedNode?.next = newNode
                        return true
                    } else {
                        existedNode = existedNode.next
                    }
                }
            }
        }
    }

    override fun iterator(): MutableIterator<T> {
        return object : MutableIterator<T> {

            private var nodeIndex = 0
            private var nextNode = elements[nodeIndex]
            private var nextIndex = 0

            override fun hasNext(): Boolean {
                return nextIndex < size
            }

            override fun next(): T {
                while (nextNode == null) {
                    nextNode = elements[++nodeIndex]
                }
                return nextNode?.item!!.also {
                    nextIndex++
                    nextNode = nextNode?.next
                }
            }

            override fun remove() {

            }
        }
    }

    private fun getElementPosition(element: T, arraySize: Int): Int {
        return abs(element.hashCode() % arraySize)
    }

    data class Node<T>(
        val item: T,
        var next: Node<T>? = null,
    )

    companion object {
        private const val INITIAL_CAPACITY = 16
        private const val LOAD_FACTOR = 0.75
    }
}