package collections


class CustomHashSet<T> : CustomMutableSet<T> {

    private val map = CustomHashMap<T, Any>()

    override val size: Int
        get() = map.size

    override fun contains(element: T): Boolean {
       return map.containsKey(element)
    }

    override fun add(element: T): Boolean {
        return map.put(element, PRESENT) == null
    }

    override fun remove(element: T) {
        map.remove(element)
    }

    override fun clear() {
        map.clear()
    }

    override fun iterator(): MutableIterator<T> = map.keyIterator()

    companion object {
        private val PRESENT = Any()
    }
}