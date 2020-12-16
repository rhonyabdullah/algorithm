package ula

/**
 * Project hackerrank.
 *
 * Created by Rhony  on 16/12/20.
 */
fun main() {
    val t = readLine()!!.toInt()
    val tS = mutableListOf<String>()
    repeat(t) { tS.add(readLine()!!.toString()) }
    val setText = mutableMapOf<Char, Int>()
    tS.forEach { text ->
        val arrS = text.toCharArray()
        arrS.forEach { charKey ->
            val lastCount = setText.getOrDefault(charKey, 0)
            setText[charKey] = lastCount+1
        }
        var combined = ""
        for ((key, value) in setText) {
            combined = "$combined$key$value"
        }
        setText.clear()
        println(combined)
    }
}
