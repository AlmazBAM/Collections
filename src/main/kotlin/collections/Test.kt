package collections

import kotlin.random.Random

fun main() {
    val a = CustomArrayList<Int>()
    repeat(100) {
        a.add(it)
    }

    a.forEach(::println)
}