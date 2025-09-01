package collections

interface NumbersMutableList {
    val size: Int
    fun contains(number: Int): Boolean
    fun get(index: Int): Int
    fun add(number: Int)
    fun add(index: Int, number: Int)
    fun removeAt(index: Int)
    fun remove(number: Int)
    fun clear()
}