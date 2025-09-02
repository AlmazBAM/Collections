package collections

import kotlin.random.Random
import kotlin.time.measureTime

fun main() {
    val a = NumbersHashSet()
    repeat(100) {
        a.add(Random.nextInt(1000))
    }

    a.elements.forEach(::println)
}