@file:Suppress("FunctionName")

package udemy_livecodinginterview

import org.junit.Assert.assertArrayEquals
import org.junit.Test
import java.util.*
import kotlin.math.abs

/**
 * Project hackerrank.
 *
 * Created by Rhony  on 12/10/20.
 */
class AbsoluteValueSortTest {

    val array = intArrayOf(0, -2, -2, 7, 2)
    private val expected = intArrayOf(0, -2, -2, 2, 7)

    @Test
    fun `absolute value order`() {
        assertArrayEquals(expected, absSort(array))
    }
}

private fun absSort(array: IntArray): IntArray {
    val list = mutableListOf<Int>()
    array.forEach { list.add(it) }
    Collections.sort(list, absComparator)

    for (i in list.indices) {
        array[i] = list[i]
    }

    return array
}

@Suppress("ObjectLiteralToLambda")
private val absComparator
    get() = object : Comparator<Int> {
        override fun compare(a: Int, b: Int): Int {
            return when {
                abs(a) < abs(b) -> -1
                abs(a) > abs(b) -> 1
                a < b -> -1
                a > b -> 1
                else -> 0
            }
        }
    }
