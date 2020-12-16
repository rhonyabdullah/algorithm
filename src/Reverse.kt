/**
 * Project hackerrank.
 *
 * Created by Rhony  on 16/12/20.
 */
fun main() {
    val n = readLine()!!.toInt()
    val arrN = IntArray(n)
    for (i in 0 until n) {
        arrN[i] = readLine()!!.toInt()
    }
    arrN.reverse()
    arrN.forEach { println(it) }
}
