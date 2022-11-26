package basics

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    GlobalScope.launch {
        delay(timeMillis = 2000)
        println("World!")
    }

    print("Hello ")
    // Wait till the thread completes
    // Should be greater than thread delay
    Thread.sleep(4000)
}