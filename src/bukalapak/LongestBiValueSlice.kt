@file:Suppress("FunctionName")

package bukalapak

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Project hackerrank.
 *
 * Created by Rhony  on 20/10/20.
 */
class LongestBiValueSliceTest {

    @Test
    fun `given array A return 4 as the index length from (0,3)`() {
        val testSubject = arrayOf(5, 4, 4, 5, 0, 12)
        assertEquals(4, bestSliceLength(testSubject))
    }

    @Test
    fun `given array A return 3 by (1,3)`() {
        val testSubject = arrayOf(0, 4, 4, 5, 0, 12)
        assertEquals(3, bestSliceLength(testSubject))
    }

}

private fun bestSliceLength(arr: Array<Int>): Int {
    var bestLength = 0
    for (i in arr.indices) {
        println("i>>>: $i")
        for (j in 1 until arr.size) {
            println(">>>j: $j")
            val sliced = arr.slice(i..j)
            val distinct = sliced.distinct()
            if (distinct.size <= 2 && sliced.size > bestLength) bestLength = sliced.size
        }
    }
    return bestLength
}
