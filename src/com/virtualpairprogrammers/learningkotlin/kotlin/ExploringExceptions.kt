package com.virtualpairprogrammers.learningkotlin.kotlin

import java.io.FileInputStream
import java.lang.ArithmeticException

@Throws (InterruptedException::class) // most of the time you won t add @throws annotation. The only time you use it if someone is calling this method from java and it s important that the java program handle the exception that could be thrown by the function
fun divide(a: Int, b: Int) : Double {
    Thread.sleep(1000)
    return ( a.toDouble() / b)
}

/////// Using the use expression to ensure resources are always closed
fun printFile() {
    val input = FileInputStream("file.txt")
    input.use {
        // An exception could be thrown then the object will be automatically closed because of use
    }
}

fun main() {

    try {
        println(7/0) // java.lang.ArithmeticException
    } catch (e: ArithmeticException) {
        println("caught")
    }

    ////// All exception in Kotlin are unchecked
    Thread.sleep(1000) // will compile fine even if thread.sleep could throw exception (In java you must have a try catch or throw exception in method signature)

    divide(5,23)

    //////// try as an expression
    var result = try {
        divide(5,23)
    } catch (e: Exception) {
        0
    }
    println(result)




}