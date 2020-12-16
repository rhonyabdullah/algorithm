package bukalapak

/**
 * Project hackerrank.
 *
 * Created by Rhony  on 16/12/20.
 */
fun main() {
    val n = readLine()!!.toInt()
    val arrStr = mutableListOf<String>()
    repeat(n) {
        arrStr.add(readLine()!!.toString())
    }

    val camelReg = Regex("(?<=[a-zA-Z])[A-Z]")
    arrStr.forEach {
        val result = camelReg.replace(it) { res ->
            "_${res.value}"
        }.toLowerCase()
        println(result)
    }
}
