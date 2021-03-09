package com.virtualpairprogrammers.learningkotlin.kotlin


// In kotlin function can exists in classes or outside classes (In java function has to be in a class)
// this function is a top level function public and static by default . It can be used in all files within the same packages
fun printAString(value: String) :Unit { // Function without returning type are returning void or in Kotlin terminology Unit
    val myUnit : Unit
    // But Unit is an object so it s not null
    println(value)
}

private fun printAString2(value: String)  { // by putting private we can only use this function within this file
    println(value)
}

fun main() { // the main methode can t be privat because you then can t execute it
    printAString("Hello World")
    println(addTwoNumbers2(1.1 ,2.3))
    printSomeMaths(two = 17.3, one = 9.6) // Using named parameters
    println(addTwoNumbers3(5.0))
    println(addTwoNumbers3(two = 5.0))
}


/////////////////////////// Single expression function
// long version
fun addTwoNumbers(one: Double, two: Double) : Double {
    return one + two
}

// short version, can only contain one line of code
fun addTwoNumbers2(one: Double, two: Double)  = one + two


/////////////////////////// Name parameters cf fun maim
fun printSomeMaths(one: Double, two: Double) {
    println("one + two is ${one + two}")
    println("one - two is ${one - two}")
}

// default value
fun addTwoNumbers3(one: Double = 6.0, two: Double = 3.0)  = one + two


/////////////// IMPORTANT Parameters attributes are always immutable (val)


////////////////////// function within function
fun printSomeMaths2(one: Double, two: Double) {
    println("one + two is ${one + two}")
    println("one - two is ${one - two}")

    fun functionWithinAFunction(a: String) { // only visible within that function
        println(a)
    }

    functionWithinAFunction("Hello")
}

//////////////// Lambda parameter (to pass a function as parameter)
fun methodTakesALambda(input: String, action: (String) -> Int ) {
    println(action(input))
}