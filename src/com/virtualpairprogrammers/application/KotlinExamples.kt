package com.virtualpairprogrammers.application
// Functional Programming
import com.virtualpairprogrammers.utilities.toSentenceCase


fun applySomeFuctionToAString(inputString: String, myFunction : (String) -> String) : String {
    return myFunction(inputString)
}

fun main() {
    val result = applySomeFuctionToAString("hello") { x -> x[0].toUpperCase() + x.substring(1)}
    println(result)

    val result3 = applySomeFuctionToAString("hello") { it.toUpperCase()} // it refers to the default parameter if it s a single parameter lambda
    println(result3)

    val result2 = applySomeFuctionToAString("hello", ::toSentenceCase)
    println(result2)

    val colors = listOf("red", "green", "blue", "black")
    val uppercaseColors = colors.map { it.toUpperCase()}
    uppercaseColors.forEach { println(it)}

    val colorsStartedWithB = colors.filter { it.startsWith("b")}
    colorsStartedWithB.forEach { println(it)}

    // flatMap to create new list of any length we like
    colors.flatMap { if (it.startsWith("b")) listOf(it,it) else listOf(it)  }.forEach { println(it)}

    // reduce, return au collection to a single value
    println(colors.reduce {result, value -> "$result, $value"})

    val numbers = colors.map {it.length}
    numbers.forEach { println(it)}
    println(numbers.sum())
    println(numbers.average())
    println(numbers.count())

    // Fold
    println(numbers.fold (0) { result, value -> result + value}) // sum of collection
    println(numbers.fold (0) { result, value -> if (value > result) value else result})

    // working with maps
    val myMap = mapOf(1 to "one", 2 to "two", 3 to "three")
    myMap.filter { (k,v) -> v.startsWith("t") }.forEach { (k,v) -> println("$k $v")}
    myMap.filter { it.value.startsWith("t") }.forEach { (k,v) -> println("$k $v")}
}