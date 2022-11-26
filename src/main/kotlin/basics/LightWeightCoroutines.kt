package basics

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        repeat(times = 100_000) {
            launch {
                print(".")
            }
        }
    }
}