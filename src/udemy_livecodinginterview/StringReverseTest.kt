@file:Suppress("FunctionName")

package udemy_livecodinginterview

import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

/**
 * Project hackerrank.
 *
 * Created by Rhony  on 15/09/20.
 */
class StringReverseTest {

    private lateinit var testSubject: StringReverse

    @Before
    fun setup() {
        testSubject = StringReverse()

    }

    @Test
    fun `string reverse by logical`() {
        assertEquals("sOcam", testSubject.reverse("macOs"))
        assertEquals("aisenodnI kilbupeR", testSubject.reverse("Republik Indonesia"))
    }

    @Test
    fun `string reverse by api`() {
        assertEquals("sOcam", testSubject.reverseApi("macOs"))
        assertEquals("aisenodnI kilbupeR", testSubject.reverseApi("Republik Indonesia"))
    }

}

private class StringReverse {

    fun reverseApi(text: String): String {
        var result = ""
        return result
    }

    fun reverse(text: String): String {
        val chars = text.toCharArray()
        println("chars before: ${String(chars)}")

        var left = 0
        var right = text.length - 1

        while (left < right) {
            val temp = chars[left]
            chars[left] = chars[right]
            chars[right] = temp
            left++
            right--
        }

        println("chars after: ${String(chars)}")
        return String(chars)
    }

}

