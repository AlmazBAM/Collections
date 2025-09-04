package collections

interface CustomSet <T> : CustomCollection<T> {
    override val size: Int
    override fun contains(element: T): Boolean
}