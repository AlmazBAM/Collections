package collections

import kotlin.time.measureTime

fun main() {
    val a = NumbersArrayList()

    val time = measureTime {
        repeat(500_000) {
            a.add(0, it)
        }
    }

    println("time = $time")
}