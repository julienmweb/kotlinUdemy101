package com.virtualpairprogrammers.learningkotlin.kotlin

fun main() {
    // var name: String = null // Won t compile , by default no variable can contains null value

    var name: String? = null
    // println(name.toUpperCase()) the code won t compile because name is null


    println(name?.toUpperCase()) // null safe operator - if name is null print null otherwise print name to uppercase

    if (name != null) { // old fashioned way
        println(name.toUpperCase())
    }

    ///////////////// Non null Asserted Operator
    val result = name!!.toUpperCase() // We are assuring kotlin that this variable does not contain null value DANGEROUS NullPointerException


    var address = null // No Explicit Type, so object type is "Nothing" and can never have a value
    //address = "test" // won t work

    var myInteger = 7
    // myInteger = null // won t work because myInteger is a non nullable variable

    var myInteger2 :Int? = 7
    myInteger2 = null // it s working


}