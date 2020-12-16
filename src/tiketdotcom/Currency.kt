@file:Suppress("FunctionName")

package tiketdotcom

import org.junit.Assert.assertArrayEquals
import org.junit.Test

/**
 * Project hackerrank.
 *
 * Created by Rhony  on 21/09/20.
 */
class Currency {

    private val currency = mapOf(2 to 2000L, 5 to 5000L, 10 to 10000L, 20 to 20000L, 50 to 50000L)

    /**
     * input, money, 65.000,
     *
     * in: val, out: array
     */

    @Test
    fun `given money 26000 should return 20000, 5000 and 2000`() {
        val expected = arrayOf(20000L, 5000L, 2000L)
        assertArrayEquals(expected, refundMoney(26000L))
    }

    private fun refundMoney(money: Long): Array<Long> {
        val result: Array<Long> = arrayOf()
        return result
    }

}
