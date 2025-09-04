package collections

interface CustomMutableSet <T> : CustomSet<T>, CustomMutableCollection<T> {
    override val size: Int
    override fun contains(element: T): Boolean
    override fun add(element: T): Boolean
    override fun remove(element: T)
    override fun clear()
}