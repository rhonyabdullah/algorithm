package halodoc

import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

/**
 * Project hackerrank.
 *
 * Created by Rhony  on 14/09/20.
 */
@Suppress("FunctionName") class IntegerReverseTest {

    private lateinit var testSubject: IntegerReverse

    @Before
    fun setUp() {
        testSubject = IntegerReverse()
    }

    @Test
    fun `reverse by string`() {
        assertEquals(123, testSubject.reverseByString(321))
        assertEquals(-321, testSubject.reverseByString(-123))
    }

    @Test
    fun `reverse by int`() {
        assertEquals(345, testSubject.reverseByInt(543))
    }
}

private class IntegerReverse {

    fun reverseByString(x: Int): Int {
        val isNegative = x.isNegative()
        val reversed = (if (isNegative) x * -1 else x).toString().reversed().toInt()
        return if (isNegative) reversed * -1 else reversed
    }

    fun reverseByInt(x: Int): Int {
        var reverse = 0
        var lastDigit: Int

        var tempX = if (x.isNegative()) x * -1 else x
        while (tempX >= 1) {
            lastDigit = tempX % 10
            reverse = reverse * 10 + lastDigit
            tempX /= 10
            println("tempX :$tempX")
            println("reversed value :$reverse")
        }

        return if (x.isNegative()) reverse * -1 else reverse
    }

    private fun Int.isNegative(): Boolean = this < 0

}
