package tiketdotcom

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Project hackerrank.
 *
 * Created by Rhony  on 15/09/20.
 */
class FibonacciTest {

    @Test
    fun testFibonnaci_10_20() {
        assertEquals(arrayListOf(13), fibonnaci(10, 20))
    }

    @Test
    fun testFibo_2_10() {
        assertEquals(arrayListOf(2,3,5,8), fibonnaci(2, 10))
    }
}

private fun fibonnaci(min: Int, max: Int): List<Int> {

    val result = mutableListOf<Int>()
    var current = 0 //8, 13
    var next = 1 //13,

//    10, 20
    while (current < max) {
        println("$current") //13
        val sum = current + next// 1, 21
        current = next //1 // 13
        next = sum //1, 21
        println("Sum : $sum")
        if (sum in min..max) {
            println("Added sum :$sum")
            result.add(sum)
        }
    }

    return result
}