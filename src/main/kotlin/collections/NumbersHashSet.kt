package collections

import kotlin.math.abs

class NumbersHashSet : NumbersMutableSet {

    var elements = arrayOfNulls<Node>(INITIAL_CAPACITY)
    override var size: Int = 0
        private set

    override fun contains(number: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun add(number: Int): Boolean {
        increaseSize()
        return add(number, elements).also { if (it) size++ }
    }

    override fun remove(number: Int) {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }



    private fun increaseSize() {
        if (size.toFloat() /  elements.size >= LOAD_FACTOR) {
            val newArray = arrayOfNulls<Node>(elements.size * 2)
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

    private fun add(number: Int, array: Array<Node?>): Boolean {
        val newNode = Node(number)
        val nodePosition = getElementPosition(number, array.size)
        var existedNode = array[nodePosition]
        if (existedNode == null) {
            array[nodePosition] = newNode
            return true
        } else {
            while (true) {
                if (existedNode?.item == number) {
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

    private fun getElementPosition(number: Int, arraySize: Int): Int {
        return abs(number % arraySize)
    }

    data class Node(
        val item: Int,
        var next: Node? = null,
    )

    companion object {
        private const val INITIAL_CAPACITY = 16
        private const val LOAD_FACTOR = 0.75
    }
}