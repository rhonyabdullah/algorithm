@file:Suppress("FunctionName")

package udemy_livecodinginterview

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.*

/**
 * Project hackerrank.
 *
 * Created by Rhony  on 17/09/20.
 */
class StackByQueueTest {

    private lateinit var testSubject: StackByQueue<String>

    @Before
    fun setup() {
        testSubject = StackByQueue()
    }

    @Test
    fun `test queue by stack string`() {
        testSubject.enqueue("alpha")
        testSubject.enqueue("beta")
        testSubject.enqueue("carly")
        testSubject.enqueue("delta")

        assertEquals(Optional.of("alpha"), testSubject.dequeue())
        assertEquals(Optional.of("beta"), testSubject.dequeue())
        assertEquals(Optional.of("carly"), testSubject.dequeue())
        assertEquals(Optional.of("delta"), testSubject.dequeue())
        assertEquals(Optional.empty<String>(), testSubject.dequeue())
    }
}

private class StackByQueue<T> : Iterable<T> {

    private val stack = Stack<T>()

    fun enqueue(item: T) {
        stack.push(item)
    }

    fun dequeue(): Optional<T> = if (stack.isNotEmpty()) {
        val item: T = stack.iterator().next()
        stack.removeAt(0)
        Optional.of(item)
    } else Optional.empty()

    override fun iterator(): Iterator<T> = stack.iterator()
}
