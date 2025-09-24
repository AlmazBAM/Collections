package collections

interface CustomList<out T> : CustomCollection<T> {
    override val size: Int
    override fun contains(element: @UnsafeVariance T): Boolean
    operator fun get(index: Int): T
}