package com.virtualpairprogrammers.learningkotlin.kotlin

import java.math.BigDecimal
import kotlin.math.roundToInt

fun main() {

    ////////////////////// Double
    val myDouble = 21.4
    println("Is myDouble a Double? ${myDouble is Double}")
    println("myDouble is a ${myDouble::class.qualifiedName}")
    println("myDouble's javaClass is ${myDouble.javaClass}")

    ////////////////////// Int
    val myInteger = myDouble.roundToInt();
    println("myInteger is a ${myInteger::class.qualifiedName}")

    val anotherInteger : Int = 17;
    //val anotherInteger : Integer = 17; Will not work it s Int in kotlin

    ////////////////////// Float BigDecimal
    val myFloat : Float = 13.6f

    val result = myFloat + anotherInteger
    println(result)

    val bd = BigDecimal(17)
    val bd2 : BigDecimal

    //println(bd2.abs()) won't compile because it s not initialized
    println("Big Decimal")
    bd2 = bd.add(BigDecimal(30))

    ////////////////////// String
    var name: String = "Matt" // mutable variable
    var rename = "test" // guess the type automatically
    val surname: String = "Greencroft" // immutable variable
    name = "John"
   println(name + " " + surname)
   println ("Hello $name ${surname.toUpperCase()}") // string templates
   println("The \$name variable - Your first name has ${name.length} characters")


    val story = """It was dark.
        |A foul smell crept
        |Jane is here.""".trimMargin("|")
    println(story)

    val changedStory = story.replaceAfterLast("is", " would be dawn.")
    println(changedStory)

}