@file:Suppress("FunctionName")

package bukalapak

import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Project hackerrank.
 *
 * Created by Rhony  on 21/10/20.
 */
class Bukalapak {

    @Test
    fun `given S=Wed and K=2 should return Fri`() {
        assertEquals("Fri", daysOfWeekTest("Wed", 2))
    }

    @Test
    fun checkValidPhone() {
        val testSubject = "123-123-123"
        Assert.assertTrue(solutionValidPhoneNumberTest(testSubject))
    }
}

fun daysOfWeekTest(S: String, K: Int): String {
    val days = arrayOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
    var startI = 0
    days.filterIndexed { index, s ->
        if (S == s) startI = index
        S == s
    }

    var jump = K
    while (jump > 0) {
        startI = if (startI + 1 > days.size - 1) 0 else startI + 1
        jump--
    }
    return days[startI]
}

fun solutionValidPhoneNumberTest(S: String): Boolean {

    //check if string contains forbidden regex
    val forbiddenReg = "[\\s]|[_#]|[a-zA-Z]".toRegex()
    if (S.contains(forbiddenReg)) return false

    //check that string should contain valid char separator
    if (!S.contains("-")) return false


    val splitted = S.split("-")
    for (each in splitted) {
        if (each.length % 3 != 0) return false
    }
    val separatorCount = S.split("[^-]".toRegex()).filter { it == "-" }

    return splitted.size == separatorCount.size + 1
}
