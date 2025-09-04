package collections

import javax.swing.text.Element

fun<T> customListOf(vararg elements: T): CustomList<T> {
    return ImmutableList<T>(*elements)
}

private class ImmutableList<T>(vararg elements: T): CustomList<T> {

    private val array = elements

    override val size: Int
        get() = array.size

    override fun contains(element: T): Boolean {
        return array.contains(element)
    }

    override fun get(index: Int): T {
        return array[index]
    }

    override fun iterator(): Iterator<T> {
        return array.iterator()
    }
}