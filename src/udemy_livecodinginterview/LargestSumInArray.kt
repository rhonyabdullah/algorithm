@file:Suppress("FunctionName")

package udemy_livecodinginterview

import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.math.max

/**
 * Project hackerrank.
 *
 * Created by Rhony  on 16/09/20.
 */
class LargestSumInArrayTest {

    @Test
    fun `find largest sum in continuous array`() {
        val sumArray = arrayOf(-2, -3, 4, -1, -2, 1, 5, -3)
        assertEquals(7, findLargestSumInArray(sumArray))
    }

}

private fun findLargestSumInArray(arrays: Array<Int>): Int {
    var maxSoFar = 0
    var currentMax = 0
    arrays.forEach { value ->
        currentMax = max(value, currentMax + value)
        maxSoFar = max(currentMax, maxSoFar)
    }
    println("Largest sum: $maxSoFar")
    return maxSoFar
}