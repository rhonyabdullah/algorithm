package ula

import java.text.SimpleDateFormat
import kotlin.math.abs

/**
 * Project hackerrank.
 *
 * Created by Rhony  on 16/12/20.
 */
fun main(){
    val sdf = SimpleDateFormat("HH:mm:ss")
    val startTime = sdf.parse(readLine()!!.toString())
    val n = readLine()!!.toInt()
    val timeList = mutableListOf<String>()
    repeat(n){timeList.add(readLine()!!.toString())}
    timeList.forEach { endTime ->
        val endDate = sdf.parse(endTime)
        val diff = endDate.time - startTime.time
        var sec = abs(diff / 1000)
        val min = abs(sec / 60)
        val hours = abs(min / 60)
        // println(endTime)
        if(hours == 0L && sec == 0L && min == 0L) println("now")
        else if(hours > 0L) println("$hours hours ago")
        else if(min > 0L) println("$min minute ago")
        else if(sec > 0L) println("$sec seconds ago")
    }
    val a = "IntArray(3)".split(" ")
    a.last()
    IntArray(2)

}
