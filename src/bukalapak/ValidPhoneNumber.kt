package bukalapak

import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Project hackerrank.
 *
 * Created by Rhony  on 21/10/20.
 */
class ValidPhoneNumberTest {

    @Test
    fun checkValidPhone() {
        val testSubject = "123-123-123"
        assertTrue(solution(testSubject))
    }
}

private fun solution(S: String): Boolean {

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
