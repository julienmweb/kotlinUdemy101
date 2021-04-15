package com.virtualpairprogrammers.learningkotlin.kotlin

import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.memberProperties


fun main() {

    val myList = listOf(14,15,16,17,18,19,20)

    myList::class.memberProperties
    val functions = myList::class.declaredFunctions
    println(functions)
}