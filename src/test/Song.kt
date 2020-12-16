import java.lang.RuntimeException

/**
 * Project hackerrank.
 *
 * Created by Rhony  on 06/08/20.
 */
fun main() {
    val songsCount = readLine()!!.trim().toInt()
    val songs = Array<Int>(songsCount, { 0 })
    for (i in 0 until songsCount) {
        val songsItem = readLine()!!.trim().toInt()
        songs[i] = songsItem
    }

    val result = playlist(songs)
    println("result $result")
}

//fun playlist(songs: Array<Int>): Long {
//    var result: Long = 0
//    val mut = songs.toMutableList()
//    println("Mut ${mut} ")
//    val mutRes = mut.removeIf { it >= 60 }
//    println("Mut Res ${mutRes}")
//
//    return result
//}

//30, 20, 150, 100, 40
fun playlist(songs: Array<Int>): Long {
    // Write your code here
    val min = 60
    var result: Long = 0
    if (songs.all { it % min == 0 }) {
        result += songs.size
        return result
    }

    var i = 0
    var j = 0
    while (i < songs.size - 1) {
        println("i $i")
        while (j < songs.size - 1) {
            println("j $j")
            println("songs[i] + songs[j] ${songs[i]}, ${songs[j]} ")
            if (i == j) {
                j++
            } else if ((songs[i] + songs[j]).rem(min) == 0) {
                println("else if ${songs[i] + songs[j]}")
                result++
                j++
            } else {
                println("Uncatch ${songs[i] + songs[j]}")
                println("Uncatch condition i $i , j$j, songs[i] + songs[j] = ${songs[i] + songs[j]}")
                j++
            }
        }
        j = 0
        i++
    }

    return result / 2
}