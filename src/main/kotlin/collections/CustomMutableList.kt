package collections

interface CustomMutableList<T> : CustomMutableCollection<T> {
    override val size: Int
    override fun contains(element: T): Boolean
    operator fun get(index: Int): T
    operator fun plus(element: T)
    operator fun minus(element: T)
    override fun add(element: T): Boolean 
    fun add(index: Int, element: T)
    fun removeAt(index: Int)
    override fun remove(element: T)
    override fun clear()
}