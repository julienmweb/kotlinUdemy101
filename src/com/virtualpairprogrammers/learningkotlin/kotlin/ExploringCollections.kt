package com.virtualpairprogrammers.learningkotlin.kotlin

fun main() {
    // create an immutable list
    val colors = listOf("Red", "Green", "Blue")
    println(colors::class.qualifiedName) // java.util.Arrays.ArrayList // without add or remove method to make it immutable
    println(colors[2])

    // create a mutable list
    val days = mutableListOf("Monday", "Tuesday", "Wednesday")
    val numbers = mutableListOf<Int>()

    // creating sets ans map ( set and map are immutable)
    // Set is implemented by extending the collection interface. It doesn't allow us to add the same element to it. It doesn't maintain the insertion order because it contains elements in a sorted way.
    val months = setOf("Jan", "Feb")
    val months2 = mutableSetOf("Jan", "Feb")
    val numbers2 = setOf<Int>()

    //  Map is also used for storing collection of objects as a single unit. Each object is store in a key-value pair. We can easily access the value using just the key because each value is associated with a unique value.
    val webColor = mapOf("red" to "ff000", "blue" to "00ff00")


    // Array . Array are always mutable . Fixed sized
    // the 3 lines below do the same thing
    val intArray : Array<Int> = arrayOf(1,2,3,4,5)
    val intArray2  = arrayOf(1,2,3,4,5)
    val intArray3 : IntArray = intArrayOf(1,2,3,4,5)
    intArray3.set(3, -4)
    intArray3[2] = -7
    intArray3.forEach { println(it)  }

    // In general we create list instead of arrays because we have more functionalities with them

}