package collections


class CustomLinkedList<T> : CustomMutableList<T> {

    private var first: Node<T>? = null
    private var last: Node<T>? = null

    private var modCount = 0
    override var size: Int = 0
        private set

    override fun contains(element: T): Boolean {
        var node = first
        repeat(size) {
            if (node?.item == element) {
                return true
            } else {
                node = node?.next
            }
        }
        return false
    }

    override fun get(index: Int): T {
        return getNode(index).item
    }

    override fun plus(element: T) {
        add(element)
    }

    override fun minus(element: T) {
        remove(element)
    }

    override fun add(element: T): Boolean {
        modCount++
        val prevLast = last
        last = Node(element, prev = prevLast)
        if (prevLast == null) {
            first = last
        } else {
            prevLast.next = last
        }
        size++
        return true
    }

    override fun add(index: Int, element: T) {
        modCount++
        checkIndexForAdding(index)
        if (index == size) {
            add(element)
            return
        }
        if (index == 0) {
            val node = Node(element, first)
            first?.prev = node
            first = node
            size++
            return
        }
        val before = getNode(index - 1)
        val after = before.next
        val node = Node(element, after, before)
        before.next = node
        after?.prev = node
        size++
    }

    override fun iterator(): MutableIterator<T> {
        return object : MutableIterator<T> {

            private var nextNode = first
            private val currentModCount = modCount

            override fun hasNext(): Boolean {
                return nextNode != null
            }

            override fun next(): T {
                if (modCount != currentModCount) throw ConcurrentModificationException()
                return nextNode?.item!!.also {
                    nextNode = nextNode?.next
                }
            }

            override fun remove() {

            }
        }
    }

    override fun removeAt(index: Int) {
        modCount++
        checkIndex(index)
        val node = getNode(index)
        unlink(node)
    }

    override fun remove(element: T) {
        modCount++
        var node = first
        repeat(size) {
            if (node?.item == element) {
                unlink(node)
                return
            } else {
                node = node?.next
            }
        }
    }

    override fun clear() {
        first = null
        last = null
        size = 0
    }

    private fun unlink(node: Node<T>) {
        val before = node.prev
        val after = node.next

        before?.next = after
        after?.prev = before
        if (after == null) {
            last = before
        }
        if (before == null) {
            first = before
        }
        size--
    }

    private fun getNode(index: Int): Node<T> {
        checkIndex(index)
        if (index == 0) return first!!
        if (index == size - 1) return last!!

        if (index < size / 2) {
            var node = first
            repeat(index) {
                node = node?.next
            }
            return node!!
        } else {
            var node = last
            repeat(size - index - 1) {
                node = node?.prev
            }
            return node!!
        }
    }

    private fun checkIndexForAdding(index: Int) {
        if (index !in 0..size)
            throw IndexOutOfBoundsException("Index: $index, Size: $size")
    }

    private fun checkIndex(index: Int) {
        if (index !in 0..<size)
            throw IndexOutOfBoundsException("Index: $index, Size: $size")
    }

    class Node<T>(
        val item: T,
        var next: Node<T>? = null,
        var prev: Node<T>? = null
    )

}