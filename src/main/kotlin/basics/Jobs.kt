package basics

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    // launch() creates a job
    // Allows us to manipulate the lifecycle
    // can access variable and methods like cancel(), join() etc

    // If  job is canceled, parent and child will also be canceled

    runBlocking {
        val job1 = launch {
            println("Job 1 launched")
            val job2 = launch {
                println("Job 2 launched")
                delay(3000L)
                println("Job 2 about to finish")

            }

            job2.invokeOnCompletion {
                println("Job 2 done")
            }

            val job3 = launch {
                println("Job 3 launched")
                delay(3000L)
                println("Job 3 about to finish")

            }

            job3.invokeOnCompletion {
                println("Job 3 done")
            }

        }

        job1.invokeOnCompletion {
            println("Job 1 is completed")
        }
        delay(500L)

        println("Job 1 will be canceled")

        job1.cancel()
    }
}