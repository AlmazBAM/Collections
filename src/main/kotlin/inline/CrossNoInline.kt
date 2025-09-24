package inline

import kotlin.concurrent.thread

fun main() {
//    executeAsync {
//        println("Hello")
//    }
    executeCommand({
        println("Command 1")
    }, {
        println("Command 2")
    })
}


private inline fun executeAsync(crossinline command: () -> Unit) {
    thread {
        command()
    }
}


private inline fun executeCommand(noinline command: () -> Unit, operation: () -> Unit) {
    command()
    operation()
}

