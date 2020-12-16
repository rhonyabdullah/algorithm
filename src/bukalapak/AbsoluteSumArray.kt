@file:Suppress("FunctionName")

package bukalapak

import org.junit.Assert.assertArrayEquals
import org.junit.Test
import kotlin.random.Random

/**
 * Project hackerrank.
 *
 * Created by Rhony  on 20/10/20.
 */
class AbsoluteSumArrayTest {

    @Test
    fun badumtest() {
        var result = Random.nextInt(-4, 4)
        println("Result :$result")

        var arrayI = arrayOf(1, 0)
        arrayI.contains(result)
    }

    @Test
    fun `generate random number of n array sum result should 0`() {
        val expected = IntArray(1)
        expected[0] = 0
        assertArrayEquals(expected, genArray(4))
        assertArrayEquals(expected, genArray(3))
    }
}

private fun genArray(n: Int): IntArray {
    var result = mutableListOf<Int>()

    fun randomUnique(): Int {
        println("execute randomUnique")
        val randUnique = Random.nextInt(n * -1, n)
        return if (result.contains(randUnique)) {
            randomUnique()
        } else randUnique
    }

    fun logGenArray() {
        println("execute logGenArray")
        for (i in 0 until n) {
            println("i: $i")
            result.add(randomUnique())
            if (i == (n - 2)) {
                val sum = result.sum()
                val item = sum * -1
                if (result.contains(item)) {
                    result = mutableListOf()
                    logGenArray()
                } else {
                    result.add(item)
                    break
                }
            }
        }
    }

    var sumRes = -1
    var whileCount = 0
    while (sumRes != 0) {
        println("whileCount>>> :${whileCount}")
        logGenArray()
        sumRes = result.sum()
        whileCount++
    }

    println("Result :${result.joinToString()} \n and sum :$sumRes")

    val sumResArray = IntArray(1)
    sumResArray[0] = sumRes
    return sumResArray
}
