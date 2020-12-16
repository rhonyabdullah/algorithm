@file:Suppress("FunctionName")

package bukalapak

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Project hackerrank.
 *
 * Created by Rhony  on 20/10/20.
 */
class SliceAndMergeTest {

    @Test
    fun `slice and merge string of number`() {
        val testSubject = "00-44  48 5555 83-61"
        val expected = "004-448-555-583-61"
        assertEquals(expected, sliceAndMerge(testSubject))
    }

    @Test
    fun `slice and merge double pair on last`() {
        val testSubject = "0 - 221985--324"
        val expected = "022-198-53-24"
        assertEquals(expected, sliceAndMerge(testSubject))
    }

    @Test
    fun `slice and merge third`() {
        val testSubject = "022 198 532"
        val expected = "022-198-532"
        assertEquals(expected, sliceAndMerge(testSubject))
    }

}

private fun sliceAndMerge(subject: String): String {
    val result = mutableListOf<String>()
    val number = subject.replace("[^0-9]".toRegex(), "").toCharArray()
    val isLastWith2Block = number.size % 3 == 1
    for (i in 1..number.size) {
        result.add(number[i - 1].toString())
        when {
            isLastWith2Block && number.size - i == 2 -> result.add("-")
            i % 3 == 0 && i != number.size && number.size - i != 1 -> result.add("-")
        }
    }

    return result.joinToString("")
}
