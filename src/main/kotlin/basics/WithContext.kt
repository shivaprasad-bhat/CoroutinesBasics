package basics

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() {
    // Allows us to easily change the context
    // Easily switch between dispatchers

    runBlocking {
        launch(Dispatchers.Default) {
            println("First context $coroutineContext")

            withContext(Dispatchers.IO) {
                println("Second context $coroutineContext")
            }

            println("Third context $coroutineContext")
        }
    }
}