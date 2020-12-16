@file:Suppress("FunctionName")

package udemy_livecodinginterview

import org.junit.Assert.assertArrayEquals
import org.junit.Test

/**
 * Project hackerrank.
 *
 * Created by Rhony  on 12/10/20.
 */
class MergeTwoSortedArrayTest {
    @Test
    fun `merge 2 sorted arrays`() {
        val a1 = intArrayOf(1, 3, 5, 9, 11)
        val a2 = intArrayOf(2, 4, 6, 10, 11, 16)
        val expected = intArrayOf(1, 2, 3, 4, 5, 6, 9, 10, 11, 16)
        assertArrayEquals(expected, mergeArrays(a1, a2))
    }
}

private fun mergeArrays(a1: IntArray, a2: IntArray): IntArray {
    val a1Length = a1.size
    val a2Length = a2.size
    var result = IntArray(a1Length + a2Length)
    var foundedSameValue = 0
    var a1Index = 0
    var a2Index = 0
    var mergedIndex = 0

    while (a1Index < a1Length && a2Index < a2Length) {
        when {
            a1[a1Index] < a2[a2Index] -> {
                result[mergedIndex] = a1[a1Index]
                a1Index++
            }
            a1[a1Index] > a2[a2Index] -> {
                result[mergedIndex] = a2[a2Index]
                a2Index++
            }
            else -> { //now both value is same
                result[mergedIndex] = a1[a1Index]
                a1Index++
                a2Index++
                //note this because has fixed array need to detect this and recalculate array size
                foundedSameValue++
            }
        }
        mergedIndex++
    }

    while (a1Index < a1Length) {
        result[mergedIndex] = a1[a1Index]
        a1Index++
        mergedIndex++
    }

    while (a2Index < a2Length) {
        result[mergedIndex] = a2[a2Index]
        a2Index++
        mergedIndex++
    }

    if (foundedSameValue > 0) {
        result = result.copyOf((a1Length + a2Length) - foundedSameValue)
    }

    return result
}
