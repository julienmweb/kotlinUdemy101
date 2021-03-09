package com.virtualpairprogrammers.learningkotlin.kotlin

import Seat
import java.math.BigDecimal

interface BookingManager {

    val version : String

    fun isSeatFee(seat : Seat) : Boolean
    fun reserveSeat(seat: Seat, customerID: Long) : Boolean

    fun systemStatus() = "All Operations are functional"
}

// All class in kotlin are final by default so you need to add open in front to extend from it
open class BasicBookingManager(authorisationKey: String) : BookingManager {
    override val version = "1.0"

    override fun isSeatFee(seat : Seat) = true
    override fun reserveSeat(seat: Seat, customerID: Long) = false

    init {
        if (authorisationKey != "12345") throw UnauthorisedUserException()
    }
}

// implement multiple interface
class AdvancedBookingManager : BasicBookingManager("12345"), java.io.Closeable {
    override val version = "2.0"

    fun howManyBookings() = 10

    override fun close() {}
}

// custom exception type
class UnauthorisedUserException : Throwable()

// Adding function to existing class with extension function even if the class is final
// In the package we are working in String will have the function toSentenceCase
fun String.toSentenceCase() : String {
    return this[0].toUpperCase() + this.substring(1)
}

fun main() {
    println(AdvancedBookingManager().isSeatFee(Seat(1,1, BigDecimal.ZERO, "")))

    val greeting = "welcome to the system"
    println(greeting.toSentenceCase())

}