package com.virtualpairprogrammers.learningkotlin.kotlin

// class is public by default / you can set it to private meaning you can use this class within the package only
class Customer(val name : String, val address : String, var age : Int) { // if there s nothing inside the class you can remove brackets

}

class Customer2(val name : String, val address : String, var age : Int) {
    constructor(name: String, age: Int ) : this(name, "", age)  // Creating a secondary construction and it called the primary constructor by using all the parameters the primary constructor require
}

data class Customer0(val name : String, val address : String, var age : Int) { // data class (as well as the getters and setters data class have methods than can be used out of the box (toString, hashcode, equals, copy ...)
    constructor(name: String, age: Int ) : this(name, "", age)
}

class Customer3(val name : String, val address : String, var age : Int) {
    constructor(name: String, age: Int ) : this(name, "", age) {
        println("secondary constructor")
    }

    init { // this code will run whenever the primary constructor is run
        println("init block")
    }
}

class AlternativeCustomer(val name : String, var age : Int) {
    var address: String // must be var to be set by the secondary constructor

    init {
        address = ""
    }

    constructor(name: String, address: String, age: Int) : this(name,age) { // run the primary constructor with the init block that will set address to empty string
        this.address = address
    }
}

class AnotherAlternativeCustomer (val name: String, var age:Int, val address : String = "") // Default Value

class AnotherAlternativeCustomer2 (val name: String, var age:Int, val address : String = "") {
    var approved: Boolean = false
    set(value) { // overriding setter for approved by placing it just after the variable declaration approved
        if (age >= 21) {
            field = value
        } else {
            println("you can't approve a customer under 21 years old")
        }
    }

    val nextAge
    get() = age + 1 // dummy variable get method

    operator fun component1() = name // TO be able to destructure object
    operator fun component2() = age

    fun uppercaseName()  = name.toUpperCase() // function within a class

    override fun toString() = "$name $address $age" // overriding function

    companion object { // static function
        fun getInstance() = AnotherAlternativeCustomer2("Mickey", 22, "some address")
    }

}


// you can declare a second class in the file (not like in java)
class Book {

}

fun main() {
    val customer = Customer("Matt", "10 the high road", 21)
    customer.age = 22
    println("${customer.name} is ${customer.age} years old")

    val customer2 =  Customer2("John", 31)
    println("${customer2.name} is ${customer2.age} years old")

    val customer3 =  Customer3("Billy", 32)
    println("${customer3.name} is ${customer3.age} years old")

    val anotherAlternativeCustomer = AnotherAlternativeCustomer("Matt", 21, "10 the high road")
    anotherAlternativeCustomer.age = 22
    println("${anotherAlternativeCustomer.name} is ${anotherAlternativeCustomer.age} years old")

    val anotherAlternativeCustomer2 =  AnotherAlternativeCustomer("John", 31)
    println("${anotherAlternativeCustomer2.name} is ${anotherAlternativeCustomer2.age} years old")

    /////////////////////////////////////////// Set Methode override
    val anotherAlternativeCustomer3 =  AnotherAlternativeCustomer2("John", 31)
    anotherAlternativeCustomer3.age = 19
    anotherAlternativeCustomer3.approved = true
    println("${anotherAlternativeCustomer3.approved} is ${anotherAlternativeCustomer3.age} years old!")

    val anotherAlternativeCustomer4 =  AnotherAlternativeCustomer2("John", 31)
    anotherAlternativeCustomer4.approved = true
    println("${anotherAlternativeCustomer4.approved} is ${anotherAlternativeCustomer4.age} years old")

    println("next year ${anotherAlternativeCustomer4.uppercaseName()} will be ${anotherAlternativeCustomer4.nextAge}")

    println("$anotherAlternativeCustomer4")

    val anotherAlternativeCustomer5 = AnotherAlternativeCustomer2.getInstance()
    println(anotherAlternativeCustomer5)

    // Data Class
    val customer0 = Customer0("Sally", 29)
    println(customer0)
    val customerCopy = customer0.copy(name = "Diane")
    println(customerCopy)

    // Destructuring a Data class (out of the box)
    val(name, address, age) = customer0
    println(name)

    // Destructuring a normal class (to be able to do that you need to add some function into the class (cf class AnotherAlternativeCustomer2)
    val(name2, age2) = anotherAlternativeCustomer4
    println(name2)

}
