package basics

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() {
    // Just like launch, except it returns a result
    // In form of a deferred
    // When we actually need a value, we need await()
    // if value is available, returns immediately
    // If not, pauses the thread till available

    runBlocking {
        val first = async {
            getFirstValue()
        }

        val second = async {
            getSecondValue()
        }

        println("Processing")
        delay(500L)
        println("Waiting for value")

        val one = first.await()
        val two = second.await()

        println("The total is ${one + two}")
    }
}

suspend fun getFirstValue(): Int {
    delay(1000L)
    println("Returning first value..")
    return Random.nextInt(1000)

}

suspend fun getSecondValue(): Int {
    delay(2000L)
    println("Returning second value..")
    return Random.nextInt(100)

}