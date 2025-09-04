package collections

interface CustomMutableCollection<T> : CustomCollection<T>, MutableIterable<T> {
    override val size: Int
    override fun contains(element: T): Boolean
    fun add(element: T): Boolean
    fun remove(element: T)
    fun clear()
}