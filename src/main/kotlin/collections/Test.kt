package collections

import kotlin.random.Random

fun main() {
    val a = CustomHashSet<Int>()
    repeat(100) {
        a.add(Random.nextInt(1000))
    }

    a.elements.forEach(::println)
}