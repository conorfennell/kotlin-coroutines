/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.idiomcentric
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

fun main() {
    println(App().greeting)
    // cancelAll()
    supervisedLaunch()
}

fun supervisedLaunch() {
    runBlocking {
        supervisorScope {
            launch { taskOne() }
            launch { taskTwo() }
            launch { taskException() }
        }
    }
}

fun cancelAll() {
    runBlocking {
        launch { taskOne() }
        launch { taskTwo() }
        launch { taskException() }
    }
}

suspend fun taskOne() {
    delay(1000)
    println("Task One")
}


suspend fun taskTwo() {
    delay(1000)
    println("Task Two")
}

suspend fun taskException() {
    println("Cancelling all coroutines")
    throw Exception()
}