package com.virtualpairprogrammers.learningkotlin.kotlin.kotlinJavaInterop

data class Customer (val id: Long, val name: String)

class CustomerDatabase() {
    val customers = listOf(Customer(1, "Matt"),
        Customer(2, "James"),
        Customer(3, "Dianne"),
        Customer(4, "Sally"))

    @Throws(IllegalAccessException::class) // For Java because in Java you cannot try to catch a specific exception if the exception is not known to be thrown by the code you re calling
    fun addCustomer(c : Customer) {
        throw IllegalAccessException("You cannot add a customer")
    }

    companion object {
        @JvmStatic
        fun helloWorld() =
            println("Hello world")
    }
}