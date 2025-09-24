package inline

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


fun main() {
    val list = (0..<100).toList()
    list.myFilter(object : Condition<Int> {
        override fun isSuitable(element: Int): Boolean {
//          if (it == 50) return //невозможно отменить выполнение, т.к. под капотом создается анонимный объект интерфейсного типа и return не окажется никакого влияния на метод main. Если только extend функцию указать как inline
//             delay(100) // невозможно, т.к. метод не suspend
            return element % 2 == 0
        }
    }).forEach(::println)

    list.myFilter {
        if (it == 50) return
        it % 2 == 0
    }.forEach(::println)

}

interface Condition<T> {
    fun isSuitable(element: T): Boolean
}

private fun <T> List<T>.myFilter(condition: Condition<T>): List<T> {
    val result = mutableListOf<T>()
    for (element in this) {
        if (condition.isSuitable(element))
            result.add(element)
    }
    return result
}

private inline fun <T> List<T>.myFilter(condition: (T) -> Boolean): List<T> {
    val result = mutableListOf<T>()
    for (element in this) {
        if (condition(element))
            result.add(element)
    }
    return result
}