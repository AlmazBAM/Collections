package collections

class NumbersArrayList(
    initialCapacity: Int = INITIAL_CAPACITY.also {
        println("Initialize constructor")
    }
) : NumbersMutableList {

    private var numbers = arrayOfNulls<Int>(initialCapacity)

    override var size: Int = 0
        private set

    override fun contains(number: Int): Boolean {
        for (index in numbers.indices) {
            if (numbers[index] == number)
                return true
        }
        return false
    }

    override fun add(number: Int) {
        growIfNeeded()
        numbers[size] = number
        size++
    }

    override fun add(index: Int, number: Int) {
        growIfNeeded()
        checkIndexForAdding(index)
        for (i in size downTo  index + 1) {
            numbers[i] = numbers[i - 1]
        }
        numbers[index] = number
        size++
    }

    override fun plus(number: Int) {
        add(number)
    }

    override fun remove(number: Int) {
        for (index in numbers.indices) {
            if (numbers[index] == number) {
                removeAt(index)
                return
            }
        }
    }

    override fun removeAt(index: Int) {
        checkIndex(index)
        for (i in index until size - 1) {
            numbers[i] = numbers[i + 1]
        }
        size--
        numbers[size] = null
    }

    override fun minus(number: Int) {
        remove(number)
    }

    override fun clear() {
        numbers = arrayOfNulls(10)
        size = 0
    }

    override operator fun get(index: Int): Int {
        checkIndex(index)
        return numbers[index]!!
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
        if (numbers.size == size) {
            val newArray = arrayOfNulls<Int>(2 * numbers.size)
            for (index in numbers.indices) {
                newArray[index] = numbers[index]
            }
            numbers = newArray
        }
    }

    companion object {
        init {
            println("companion object")
        }

        private const val INITIAL_CAPACITY = 10
    }

}