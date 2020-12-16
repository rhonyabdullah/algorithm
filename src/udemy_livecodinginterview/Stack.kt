@file:Suppress("FunctionName")

package udemy_livecodinginterview

import org.junit.Test
import java.util.*

/**
 * Project hackerrank.
 *
 * Created by Rhony  on 17/09/20.
 */
class StackTest {

    @Test
    fun `test stack Int operation`() {
        val stack = Stack<Int>()
        stack.push(10)
        stack.push(11)
        stack.push(1)
        val s = stack.joinToString(separator = ", ")
        println("Stack value: $s")
        val peak = stack.peek()
        println("Stack peak: $peak")
        println("stack after peak :$stack")
    }
}
