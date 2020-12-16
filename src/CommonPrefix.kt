/**
 * Project hackerrank.
 *
 * Created by Rhony  on 06/08/20.
 */
fun main() {
    val inputsCount = readLine()!!.trim().toInt()
    val inputs = Array<String>(inputsCount, { "" })
    for (i in 0 until inputsCount) {
        val inputsItem = readLine()!!
        inputs[i] = inputsItem
    }
    val result = commonPrefix(inputs)
    println(result.joinToString("\n"))
}

fun commonPrefix(inputs: Array<String>): Array<Int> {
    val result = emptyArray<Int>()

    fun getMinString(strArr: Array<String>): String {
        var minStr = strArr[0]
        for (i in 1 until strArr.size) {
            if (strArr[i].length < minStr.length) minStr = strArr[i]
        }
        return minStr
    }

    if (inputs.isEmpty()) return emptyArray()
    // Find minimum length String
    val minStr = getMinString(inputs).toCharArray()
    var minPrefixStrLength = minStr.size
    for (i in inputs.indices) {
        var j: Int = 0
        while (j < minPrefixStrLength) {
            if (minStr[j] != inputs[i][j]) break
            j++
        }
        if (j < minPrefixStrLength) minPrefixStrLength = j
    }
    println("minSrt ${minStr}")
    val a =  minStr.toString().substring(0, minPrefixStrLength)

    return result.plus(a.length)
}
