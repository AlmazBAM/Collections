package collections

interface CustomList<T> : CustomCollection<T> {
    override val size: Int
    override fun contains(element: T): Boolean
    operator fun get(index: Int): T
}