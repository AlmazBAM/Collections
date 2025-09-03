package collections

interface CustomMutableSet <T> {
    val size: Int
    fun contains(element: T): Boolean
    fun add(element: T): Boolean
    fun remove(element: T)
    fun clear()
}