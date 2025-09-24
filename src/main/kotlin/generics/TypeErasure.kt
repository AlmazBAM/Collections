package generics

import collections.CustomArrayList
import collections.CustomList
import collections.customListOf


fun main() {
    val box1 = Box(10)
    val box2 = Box(20)

    val sum = box2.value + box1.value
    println(sum)


    val workers = customListOf(Director2("John"), Programmer2("Nick"), Programmer2("Helen"))
    workers.myFilterIsInstance<Programmer2>().forEach { it.writeCode() }
}

inline fun <reified R> CustomList<*>.myFilterIsInstance(): CustomList<R> {
    val result = CustomArrayList<R>()
    for (element in this) {
        if (element is R) {
            result.add(element)
        }
    }
    return result
}

fun <T> method(element: List<T>) {
    element.forEach {
        println(it?.javaClass?.name)
    }
}

data class Box<T>(var value: T)

open class Worker2(val name: String)

class Programmer2(name: String) : Worker2(name) {
    fun writeCode() {
        println("I'm writing code")
    }
}

class Director2(name: String) : Worker2(name)