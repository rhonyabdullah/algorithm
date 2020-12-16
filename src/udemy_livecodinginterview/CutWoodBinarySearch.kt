@file:Suppress("FunctionName")

package udemy_livecodinginterview

import org.junit.Test
import kotlin.test.assertEquals

/**
 * Project hackerrank.
 *
 * Created by Rhony  on 09/10/20.
 */
class CutWoodBinarySearchTest {

    @Test
    fun `test cut wood from given array`() {
        val wood = arrayOf(5, 9, 7)
        val k = 3
        assertEquals(5, cutWood(wood, k))
    }

}

private fun cutWood(wood: Array<Int>, k: Int): Int {
    var result = 0
//    corner case
    if (wood.isEmpty() || k == 0) return result

    var left = 1
    var right = getMaxValue(wood)

    if (!isValid(wood, left, k)) return result

    while (left < right) {
        val mid = left + (right - left) / 2
        val valid = isValid(wood, mid, k)
        println("valid is $valid")
        if (valid) {
            left = mid + 1
            result = mid
        } else {
            right = mid
        }
        println("left is $left")
        println("right is $right")
    }

    return result
}

private fun getMaxValue(wood: Array<Int>): Int = wood.max() ?: 0

private fun isValid(wood: Array<Int>, cutLength: Int, k: Int): Boolean {
    var count = 0
    wood.forEach { w ->
        count += w / cutLength
    }
    return count >= k
}
