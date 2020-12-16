@file:Suppress("FunctionName")

package foodpanda

import org.junit.Assert.assertArrayEquals
import org.junit.Test

/**
 * Project hackerrank.
 *
 * Created by Rhony  on 19/10/20.
 */
class FindIndexesTest {

    private val testSubject = arrayOf(1, 4, 5, 9, 3).toIntArray()

    @Test
    fun `find indexes k 7`() {
        val k = 7
        val expected = arrayOf(1, 4).toIntArray()
        assertArrayEquals(expected, findIndexes(testSubject, k))
    }

    @Test
    fun `find indexes k 4`() {
        val k = 4
        val expected = arrayOf(1).toIntArray()
        assertArrayEquals(expected, findIndexes(testSubject, k))
    }

}

private fun findIndexes(arr: IntArray, k: Int): IntArray {
    val result = mutableListOf<Int>()
    var arrI = 0
    var remains = k

    while (remains > 0 && arrI < arr.size) {
        val arrValue = arr[arrI]
        if (remains == arrValue) {
            result.add(arrI)
            break
        }
        if (remains % arrValue == 0 && result.isEmpty()) {
            arrI++
            continue
        } else {
            val before = remains
            remains %= arrValue
            if (remains > 0 && remains != before) {
                result.add(arrI)
            } else if (remains != before) {
                result.add(arrI)
            }
        }
        arrI++
    }

    return result.toIntArray()
}
