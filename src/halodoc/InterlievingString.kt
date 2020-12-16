@file:Suppress("FunctionName")

package halodoc

import org.junit.Assert.assertTrue
import org.junit.Test
import kotlin.test.assertFalse

/**
 * Project hackerrank.
 *
 * Created by Rhony  on 16/09/20.
 */
class InterlievingStringTest {

    @Test
    fun `testInterlievingString true s1=aabcc s2=dbbca s3=aadbbcbcac`() {
        assertTrue(interleaved("aabcc","dbbca","aadbbcbcac", mutableMapOf()))
    }

    @Test
    fun `test interlieving string false s3=aadbbbaccc`() {
        assertFalse(interleaved("aabcc","dbbca","aadbbbaccc", mutableMapOf()))
    }
}


// Function to check if String X and Y are interleaving of
// String S or not
fun interleaved(
    X: String, Y: String, S: String,
    dp: MutableMap<String, Boolean>
): Boolean {
    // return true if we have reached end of all Strings
    if (X.isEmpty() && Y.isEmpty() && S.isEmpty()) {
        println("1")
        return true
    }
    // return false if we have reached the end of String S
    // but String X or Y are not empty
    if (S.isEmpty()) {
        println("2")
        return false
    }
    // calculate unique map key by using delimiter "|"
    val key = ("$X|$Y|$S")
    // if sub-problem is seen for the first time
    if (!dp.containsKey(key)) {
        // if String X is not empty and its first character matches with
        // first character of S, recur for remaining subString
        val x =
            ((X.isNotEmpty() && S[0] == X[0]) && interleaved(X.substring(1), Y, S.substring(1), dp))
        // if String Y is not empty and its first character matches with
        // first character of S, recur for remaining subString
        val y =
            ((Y.isNotEmpty() && S[0] == Y[0]) && interleaved(X, Y.substring(1), S.substring(1), dp))
        dp[key] = x || y
        println("x:$x y:$y")
        println("3 ")
    }
    return dp[key] ?: false
}
