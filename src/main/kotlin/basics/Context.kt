package basics

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Important elements
 * Dispatcher - On which coroutines runs on
 * Job - Handle on the coroutine lifecycle
 */
fun main() {
    // Context is a set of data that relates to the coroutines
    // All coroutines have an associated context

    runBlocking {
        launch(CoroutineName("testCoroutine")) {
            println("This is a run from ${coroutineContext[CoroutineName.Key]}")
        }
    }
}