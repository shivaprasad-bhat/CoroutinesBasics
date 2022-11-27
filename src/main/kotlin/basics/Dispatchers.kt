package basics

import kotlinx.coroutines.*

fun main() {
    // Decides which thread or thread pool job runs on

    // Dispatcher.Default -> CPU intensive processing ex, data processing, image processing
    // Dispatcher.Main -> to update UI driven applications
    // Dispatcher.IO -> Useful for network operations, R/W files
    // Dispatcher.Unconfined -> Starts the coroutine in the inherited dispatcher that called it
    // newSingleThreadContext -> forces the creation of new thread (not to be used frequently)


    runBlocking {
//        Below won't work as main thread is for UI
//        We don't have this in the project
//        launch(Dispatchers.Main) {
//            println("Main dispatcher.. Thread: ${Thread.currentThread().name}")
//        }

        launch(Dispatchers.Unconfined) {
            println("Unconfined dispatcher.. Thread: ${Thread.currentThread().name}")
            delay(1000L)
            println("Unconfined continued dispatcher.. Thread: ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Default) {
            println("Default dispatcher.. Thread: ${Thread.currentThread().name}")
        }

        launch(Dispatchers.IO) {
            println("IO dispatcher.. Thread: ${Thread.currentThread().name}")
        }

        launch(newSingleThreadContext("NewThread")) {
            println("newSingleThreadContext dispatcher.. Thread: ${Thread.currentThread().name}")
        }
    }

}