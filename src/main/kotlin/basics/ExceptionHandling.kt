package basics

import kotlinx.coroutines.*

@DelicateCoroutinesApi
fun main() {
    // Exception behavior depends on coroutine builder ex launch{} and async{}

    // launch::
    // Propagates through the parent child hierarchy
    // Exception will be thrown immediately and jobs will fail
    // use try catch or an exception handler

    // async::
    // Exception is deferred until the result is consumed
    // If we never call await() exception will never be thrown
    // try-catch in the coroutine of await() call

    runBlocking {
        val handler = CoroutineExceptionHandler { _, throwable ->
            println("Exception handled:: ${throwable.localizedMessage}")
        }
        val job = GlobalScope.launch(handler) {
            println("Throwing exception from Job")
            throw IndexOutOfBoundsException("Exception thrown from coroutine")
        }

        job.join()

        val deferred = GlobalScope.async {
            println("Thrown from async..")
            throw ArithmeticException("Thrown from async")
        }

        try {
            deferred.await()
        } catch (e: Exception) {
            println("Caught :: ${e.localizedMessage}")
        }
    }

}