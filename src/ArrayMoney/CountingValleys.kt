package ArrayMoney

import java.util.*

/**
 * Project hackerrank.
 *
 * Created by Rhony  on 04/08/20.
 */
fun main() {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val s = scan.nextLine()

    val result = countingValleys(n, s)

    println(result)
}

/**
 * U D D D U D U U
 */
fun countingValleys(n: Int, s: String): Int {
    val si = s.toList().map { it.toString() }
    check(n == si.size) { "N $n step didn't same with si size: ${si.size}" }

    val climbUp = "U"
    val climbDown = "D"
    var isMatchedSymbol = true
    si.forEach { if (it != climbUp || it != climbDown) isMatchedSymbol = false }
    check(!isMatchedSymbol) { "There is not matched symbol contain in list!" }

    /**
     * 0 indicate on sea level
     * + indicate above sea level
     * - indicate below sea level
     */
//                     d, u, u,  d,  d,  u,  d,  u
    var seaLevel = 0 //-1, 0, 1, 0, -1,  0, -1  0

    /**
     * When negative sea level appear, increment valley
     */
    var valleys = 0

    for (hike in si.indices) {
        val seaLevelBefore = seaLevel
        seaLevel = if (si[hike].equals(climbUp, ignoreCase = true)) seaLevel + 1 else seaLevel - 1
        if (seaLevelBefore == 0 && seaLevel < 0) valleys++
    }

    return valleys
}
