package basics

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

var functionCalls = 0

@DelicateCoroutinesApi
fun main() {
    // Suspend functions are the functions that can be run on a coroutine
    // Makes callback seamless

    GlobalScope.launch {
        completeMessage()
    }
    GlobalScope.launch {
        improveMessage()
    }
    print("Hello, ")
    Thread.sleep(2000L)
    println("There are $functionCalls calls so far..")

}

suspend fun completeMessage() {
    delay(500L)
    println("World!")
    functionCalls++
}

suspend fun improveMessage() {
    delay(1000L)
    println("Suspend functions are cool..")
    functionCalls++
}