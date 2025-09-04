package collections

class CustomArrayList<T>(
    initialCapacity: Int = INITIAL_CAPACITY.also {
        println("Initialize constructor")
    }
) : CustomMutableList<T> {

    private var elements = arrayOfNulls<Any>(initialCapacity)

    private var modCount = 0

    override var size: Int = 0
        private set

    override fun contains(element: T): Boolean {
        for (index in elements.indices) {
            if (elements[index] == element)
                return true
        }
        return false
    }

    override fun add(element: T): Boolean {
        modCount++
        growIfNeeded()
        elements[size] = element
        size++
        return true
    }

    override fun add(index: Int, element: T) {
        modCount++
        checkIndexForAdding(index)
        growIfNeeded()
        System.arraycopy(elements, index, elements, index + 1, size - index)
        elements[index] = element
        size++
    }

    override fun plus(element: T) {
        add(element)
    }

    override fun remove(element: T) {
        modCount++
        for (index in elements.indices) {
            if (elements[index] == element) {
                removeAt(index)
                return
            }
        }
    }

    override fun removeAt(index: Int) {
        modCount++
        checkIndex(index)
        System.arraycopy(elements, index + 1, elements, index, size - index - 1)
        size--
        elements[size] = null
    }

    override fun minus(element: T) {
        remove(element)
    }

    override fun clear() {
        elements = arrayOfNulls(10)
        size = 0
    }

    override operator fun get(index: Int): T {
        checkIndex(index)
        return elements[index]!! as T
    }

    override fun iterator(): MutableIterator<T> {
        return object : MutableIterator<T> {

            private var nextIndex = 0
            private val currentModCount = modCount

            override fun hasNext(): Boolean {
                return nextIndex < size
            }

            override fun next(): T {
                if (modCount != currentModCount) throw ConcurrentModificationException()
                return elements[nextIndex++] as T
            }

            override fun remove() {

            }
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

    private fun growIfNeeded() {
        if (elements.size == size) {
            val newArray = arrayOfNulls<Any>(2 * elements.size)
            System.arraycopy(elements, 0, newArray, 0, size)
            elements = newArray
        }
    }

    companion object {
        init {
            println("companion object")
        }

        private const val INITIAL_CAPACITY = 10
    }

}