package ArrayMoney

import java.util.*

/**
 * Project hackerrank.
 *
 * Created by Rhony  on 05/08/20.
 */
fun main() {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val c = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = jumpingOnClouds(c)

    println(result)
}

// Complete the warmingup.jumpingOnClouds function below.
fun jumpingOnClouds(c: Array<Int>): Int {
    var jumps = 0
    var i = 0
    while (i < c.size - 1) {
        if (i+2 == c.size || c[i+2] == 1) {
            i++
            jumps++
        } else {
            i += 2
            jumps++
        }
    }
    return jumps
}
