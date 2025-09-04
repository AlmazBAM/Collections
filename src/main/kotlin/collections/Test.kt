package collections

import kotlin.random.Random

fun main() {
    val a = customListOf(1, 2, 3, 4)
    val b = a.toList()

    val bb  = linkedSetOf<Int>()
    (b as MutableList<Int>).add(100)

    b.forEach(::println)

}