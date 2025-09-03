package collections

interface CustomMutableList<T> {
    val size: Int
    fun contains(element: T): Boolean
    operator fun get(index: Int): T
    operator fun plus(element: T)
    operator fun minus(element: T)
    fun add(element: T)
    fun add(index: Int, element: T)
    fun removeAt(index: Int)
    fun remove(element: T)
    fun clear()
}