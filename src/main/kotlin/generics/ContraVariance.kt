package generics

fun main() {
    val worker = Container<Worker>()
    val programmer = Container(Programmer("Helen"))
    val director = Container(Director("John"))

    copy(programmer, worker)
//    copy(worker, programmer) //в destination нужно передать родительский тип

    println(worker)
    println(programmer)
    println(director)

}

fun <T> copy(src: Container<out T>, dst: Container<in T>) {
    dst.value = src.value
}

data class Container<T>(var value: T? = null)