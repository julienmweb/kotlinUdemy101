import java.util.Calendar;
import java.util.GregorianCalendar;

data class KotlinPerson(
    val id: Long,
    val title: String,
    val firstName: String,
    val surname: String,
    val dateOfBirth: Calendar?
) {

    var favoriteColor : String? = null

    fun getUpperCaseColor() : String {
        return favoriteColor?.toUpperCase() ?: "" // Elvis operator . return favorite color to uppercase if not null , if null return ""
        //return if (favoriteColor == null) "" else favoriteColor.toUpperCase() // Won t compile because Smart cast to 'String' is impossible, because 'favoriteColor' is a mutable property that could have been changed by this time
    }

    fun getLastLetter(a : String) = a.takeLast(1)

    // the let function
    fun getLastLetterOfColor() : String {
        //return if (favoriteColor == null) "" else getLastLetter(favoriteColor) // Won t compile because Smart cast to 'String' is impossible, because 'favoriteColor' is a mutable property that could have been changed by this time
        return favoriteColor?.let { getLastLetter(it) } ?: "" // if favorite color is not null let function will run lambda function (getLastLetter with it as an argument . it represent favoriteColor variable) ELSE return empty string
    }

    override fun toString() = "$title $firstName $surname"

    val safeAge : Int
        get() {
            // Elvis operator for null safe check
            return age ?: -1 // return age unless it null, if it s null return -1
/*            return if (age != null) { // replaced by elvis operator
                age!! // We are assuring kotlin that this variable does not contain null value
            } else -1*/
        }

    val age: Int?
        get() = getAge(dateOfBirth)

    companion object { // declare static methods
        fun getAge(dateOfBirth: Calendar?): Int? {
            if (dateOfBirth == null) return null

            val today = GregorianCalendar()
            val years = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR)
            // if keyword as an expression
            return if (dateOfBirth.get(Calendar.DAY_OF_YEAR) >= today.get(Calendar.YEAR)) {
                years - 1
            } else {
                years
            }
            //return if (dateOfBirth.get(Calendar.DAY_OF_YEAR) >= today.get(Calendar.YEAR)) years - 1 else years // Possible to do it in a single line too
            }
        }

    // OBJECT EQUALITY
    // JAVA REFERENCE object1 == object 2
    // JAVA VALUE object1.equals(object2)
    // KOTLIN/PHP REFERENCE object1 === object2
    // KOTLIN/PHP VALUE object1 == object2

    fun getColorType() : String {
        val color = getUpperCaseColor()
        return if (color == "")
            "empty"
        else if (color == "RED" || color == "BLUE" || color == "GREEN")
            "rgb"
        else
            "other"
    }

    // When Expression (switch case in Kotlin)
    fun getColorType2() : String {
        val color = getUpperCaseColor()
        return when (color) {
            "" -> "empty"
            "RED", "GREEN", "BLUE" -> "rgb"
            else -> "other"
        }
    }


    }

fun main(args: Array<String>) {
    val john = KotlinPerson(1L, "Mr", "John", "Blue", GregorianCalendar(1977,9,3))
    val jane = KotlinPerson(2L, "Mrs", "Jane", "Green", null)
    println ("$john's age is ${john.age}")
    println ("$jane's age is ${jane.age}")
    println ("The age of someone born on 3rd May 1988 is " + KotlinPerson.getAge(GregorianCalendar(1988,5,3)))

    // Assigning a variable using an if expression
    val olderPerson = if (john.safeAge > jane.safeAge) john else jane
    println("The older person was $olderPerson")
}
