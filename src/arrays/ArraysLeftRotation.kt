package arrays

import java.util.*

/**
 * Project hackerrank.
 *
 * Created by Rhony  on 06/08/20.
 */
fun main() {
    val scan = Scanner(System.`in`)

    val nd = scan.nextLine().split(" ")

    val n = nd[0].trim().toInt()

    val d = nd[1].trim().toInt()

    val a = IntArray(n)

    val result = rotLeft(a, d)

    println(result.joinToString(" "))
}

// Complete the rotLeft function below.
fun rotLeft(a: IntArray, d: Int): IntArray {
    val n = a.size
    val rotArray = IntArray(n)
    for (oldIndex in 0 until n) {
        val newIndex = (oldIndex + n - d) % n
        rotArray[newIndex] = a[oldIndex]
    }
    return rotArray
}