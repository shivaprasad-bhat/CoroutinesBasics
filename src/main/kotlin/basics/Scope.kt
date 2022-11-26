package basics

import kotlinx.coroutines.*

@DelicateCoroutinesApi
fun main() {
    // Provides lifecycle methods for coroutines
    // Allows starting and stop coroutines

    // GlobalScope.launch { } - Scope to entire application
    // runBlocking - creates a scope and runs a coroutine in a blocking way
    // coroutineScope - Creates anew scope and does not complete until all the children complete

    println("Execution will block now..")

    runBlocking {
        launch {
            delay(1000L)
            println("Task from runBlocking..")
        }

        GlobalScope.launch {
            delay(500L)
            println("Task from GlobalScope..")
        }

        coroutineScope {
            launch {
                delay(1500L)
                println("Task from coroutineScope..")
            }
        }
    }

    println("Execution will continue now..")
}