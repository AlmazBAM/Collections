package collections

interface CustomMutableCollection<T> : MutableIterable<T> {
    val size: Int
    fun contains(element: T): Boolean
    fun add(element: T): Boolean
    fun remove(element: T)
    fun clear()
}