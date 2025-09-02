package collections

interface NumbersMutableSet {
    val size: Int
    fun contains(number: Int): Boolean
    fun add(number: Int): Boolean
    fun remove(number: Int)
    fun clear()
}