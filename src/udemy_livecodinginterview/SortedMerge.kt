@file:Suppress("FunctionName")

package udemy_livecodinginterview

import org.junit.Assert.assertArrayEquals
import org.junit.Test

/**
 * Project hackerrank.
 *
 * Created by Rhony  on 16/09/20.
 */
class SortedMergeTest {

    private val a = arrayOf(1, 3, 5, 7, 9)
    private val b = arrayOf(0, 2, 4, 6)
    private val c = arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 9)

    @Test
    fun `sort and merge array a b`() {
        assertArrayEquals(c, sortAndMerge(a, b))
    }

}

/**
 * solve, need to detect same value and create new array of int
 */
private fun sortAndMerge(a: Array<Int>, b: Array<Int>): Array<Int> {
    var pointer1 = a.size - b.size - 1
    var pointer2 = b.size - 1
    var mergedIndex = a.size - 1
    while (pointer2 >= 0) {
        println("Pointer 1 :$pointer1")
        println("Pointer 2 :$pointer2")
        println("MergedIndex :$mergedIndex")
        if (pointer1 >= 0 && a[pointer1] > b[pointer2]) {
            a[mergedIndex] = a[pointer1]
            pointer1--
        } else {
            a[mergedIndex] = b[pointer2]
            pointer2--
        }
        mergedIndex--
    }
    return a
}
