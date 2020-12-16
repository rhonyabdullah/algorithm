import org.junit.Test
import kotlin.test.assertEquals

/**
 * Project hackerrank.
 *
 * Created by Rhony  on 31/08/20.
 */
class Palindrome {
    @Test fun testEmptyString() {
        test(true, "")
    }

    @Test fun testChar() {
        test(true, "a")
    }

    @Test fun testPositive1() {
        test(true, "aba")
    }

    @Test fun testPositive2() {
        test(true, "abba")
    }

    @Test fun testPositive3() {
        test(true, "abbabba")
    }

    @Test fun testPositive4() {
        test(true, "abbaabba")
    }

    @Test fun testPositive4_2() {
        test(true, "zabbaaabbaz")
    }

    @Test fun testNegative1() {
        test(false, "ab")
    }

    @Test fun testNegative2() {
        test(false, "abab")
    }

    @Test fun testNegative3() {
        test(false, "abaa")
    }
}

private fun test(expected: Boolean, data: String) {

    fun isPalindrome(value: String): Boolean {
        // Write your solution here
        for (i in (value.length - 1) downTo 0) {
            val pointer = value.length - 1 - i
            if (pointer > i) break
            println("i: $i, pointer: $pointer")
            if (value[i] != value[pointer]) return false
        }
        return true
    }

    val actual = isPalindrome(data)
    assertEquals(expected, actual, "\ndata = \"$data\"")
}
