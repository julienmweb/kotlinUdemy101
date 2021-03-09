package com.virtualpairprogrammers.learningkotlin.kotlin

import java.math.BigDecimal
import java.util.*


fun main() {

    var result : Any // Any equivalent to Object in java
    val randomNumber = Random().nextInt(3)

    if (randomNumber == 1) {
        result = BigDecimal(30)
    } else {
        result = "hello"
    }
    println("Result is currently $result")

    if (result is BigDecimal) { // smart casting -> result is casted automatically
        result.add(BigDecimal(47))
    } else {
        val tempResult = result as String // casting
        result = tempResult.toUpperCase()

    }


    println("Result is currently $result")
}