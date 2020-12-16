@file:Suppress("FunctionName")

package udemy_livecodinginterview

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

/**
 * Project hackerrank.
 *
 * Created by Rhony  on 18/09/20.
 */
class StackRomanNumberConversionTest {

    @Test
    fun `convert roman to int positive value`() {
        assertEquals(1, convertRomanToInt("I"))
        assertEquals(154, convertRomanToInt("CLIV"))
        assertEquals(5, convertRomanToInt("V"))
    }

    @Test
    fun `convert roman to int negative value`() {
        assertEquals(-1, convertRomanToInt(null))
        assertEquals(-1, convertRomanToInt(""))
    }
}

/**
 * Return positive number else -1
 */
private fun convertRomanToInt(roman: String?): Int {

//    first check if null or empty is invalid
    if (roman.isNullOrEmpty()) return -1

//    second check if roman valid string
//    ex: some invalid roman number ("IXI", "MMMMM")
    if (!roman.matches("M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$".toRegex())) return -1

    var result = 0
    val stack = Stack<Char>()
    val array = roman.toCharArray()
    for (char in array) {
        if (stack.isEmpty()) {
            result += romanMap["$char"]!!
            stack.push(char)
        } else {
            val lastElement = stack.peek()
            val combinedElementChar = "$lastElement$char"
            if (romanMap.containsKey(combinedElementChar)) {
                result -= romanMap["$lastElement"]!!
                result += romanMap[combinedElementChar]!!
                stack.push(char)
            } else {
                result += romanMap["$char"]!!
                stack.push(char)
            }
        }
    }

    return result
}

private val romanMap
    get() = mutableMapOf(
        "I" to 1,
        "IV" to 4,
        "V" to 5,
        "IX" to 9,
        "X" to 10,
        "XL" to 40,
        "L" to 50,
        "XC" to 90,
        "C" to 100,
        "CD" to 400,
        "D" to 500,
        "CM" to 900,
        "M" to 1000
    )
