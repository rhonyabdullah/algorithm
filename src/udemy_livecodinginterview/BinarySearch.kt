@file:Suppress("FunctionName")

package udemy_livecodinginterview

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Project hackerrank.
 *
 * Created by Rhony  on 08/10/20.
 */
class BinarySearchTest {

    lateinit var searchArray: Array<Int>

    @Before
    fun setup() {
        searchArray = arrayOf(2, 3, 5, 6, 9, 11, 12, 15, 17, 21) //size 10
    }

    @Test
    fun `Recursion search`() {
        assertEquals(2, searchRecursion(searchArray, 5))
        assertEquals(5, searchRecursion(searchArray, 11))
    }

    @Test
    fun `Iteration search`() {
        assertEquals(2, searchIteration(searchArray, 5))
        assertEquals(5, searchIteration(searchArray, 11))
    }

}

private fun searchRecursion(searchArray: Array<Int>, searchFor: Int): Int {
    searchArray.sort()
    return searchRecursionHelper(searchArray, 0, searchArray.size - 1, searchFor)
}

private fun searchRecursionHelper(searcArray: Array<Int>, left: Int, right: Int, searchFor: Int): Int {
    if (left > right) return -1

    val pivot = (right - left) / 2 + left //4

    return when {
        searchFor == searcArray[pivot] -> pivot
        searchFor < searcArray[pivot] -> {
            searchRecursionHelper(searcArray, left, pivot - 1, searchFor)
        }
        else -> searchRecursionHelper(searcArray, pivot + 1, right, searchFor)
    }
}

private fun searchIteration(searchArray: Array<Int>, searchFor: Int): Int {
    searchArray.sort()

    var left = 0
    var right = searchArray.size - 1

    while (left <= right) {
        val pivot = (right - left) / 2 + left //4
        when {
            searchArray[pivot] == searchFor -> return pivot
            searchArray[pivot] < searchFor -> {
                left = pivot + 1
            }
            else -> {
                right = pivot - 1
            }
        }
    }

    return -1
}
