package collections

interface CustomCollection<T> : Iterable<T> {
    val size: Int
    fun contains(element: T): Boolean
}