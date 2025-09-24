package collections

interface CustomSet <out T> : CustomCollection<T> {
    override val size: Int
    override fun contains(element: @UnsafeVariance T): Boolean
}