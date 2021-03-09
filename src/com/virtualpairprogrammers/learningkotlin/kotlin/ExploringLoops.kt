package com.virtualpairprogrammers.learningkotlin.kotlin

import KotlinPerson

fun main() {
    var x : Int = 0
    while (x < 10) {
        //println(x)
        x++
    }

    // ArrayList is the most commonly used implementation of the List interface in Java. It is based on built-in arrays but can dynamically grow and shrink as we add or remove elements.
    val people = ArrayList<KotlinPerson>()
    people.add(KotlinPerson(1, "Mr", "James", "Apple", null))
    people.add(KotlinPerson(2, "Miss", "Sophie", "Orange", null))
    people.add(KotlinPerson(3, "Mrs", "Anita", "Kumkwat", null))
    people.add(KotlinPerson(4, "Mr", "Darren", "Banana", null))

    for (person : KotlinPerson in people) {
        println(person)
    }

    // Type can be inferred automatically
    for (person  in people) {
        val (id, title) = person
        println("$person has id $id")
    }

    for ((id, title, firstName) in people) { // destructuring as part of for each loop
        println("$title $firstName has id $id")
    }


    // HashMap Unlike ArrayList and LinkedList, HashMap implements the Map interface. That means that every key is mapped to exactly one value. We always need to know the key to retrieve the corresponding value from the collection
    val people2 = HashMap<Int, KotlinPerson>()
    people2.put(1, KotlinPerson(1, "Mr", "James", "Apple", null))
    people2.put(2, KotlinPerson(2, "Miss", "Sophie", "Orange", null))
    people2.put(3, KotlinPerson(3, "Mrs", "Anita", "Kumkwat", null))
    people2.put(4, KotlinPerson(4, "Mr", "Darren", "Banana", null))

    for ((key, value) in people2) {
        println("$value has key $key")
    }

    //////////////// Looping with range object
    val myRange = 0..9
    for (i in myRange) {
        //println(i)
    }

    for (i in 0..9) {
        //println(i)
    }

    // with a lambda function
    (0 ..9).forEach{ i -> println(i) }

    // with a lambda function short version
    (0 ..9).forEach{ println(it) }

    // different kind of range
    (9 downTo 0).forEach{ println(it) } // 9 8 7 6 5 4 3 2 1 0
    (0 until 9).forEach{ println(it) } // not including 9
    (0..9 step 2).forEach{ println(it) } // 0 2 4 6 8
    ('A'..'F').forEach{ println(it) } // A B C D E F
}