package ArrayMoney

import java.util.*

/**
 * Project hackerrank.
 *
 * Created by Rhony  on 04/08/20.
 */
fun main(args: Array<String>) {
//    var a = "Love"
//    var b = "You"
//    println("Before swap: $a $b")
//    a = a + b
//    b = a.substring(0, a.length - b.length)
//    a = a.substring(b.length)
//    println("After : $a $b")
//    repeat(9) {
//     println("random value: ${(1..10).random()}")
//    }

    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()
    println("N value : $n")

    val ar = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
    println("AR value : ${ar.joinToString(" ")}")

    val result = sockMerchant(n, ar)

    println(result)
}

fun sockMerchant(n: Int, ar: Array<Int>): Int {
    check(n == ar.size) {
        "N $n value didn't same with ar size: ${ar.size}"
    }
    var result = 0
    val memory = mutableSetOf<Int>()
    ar.forEach {
        //`true` if the element has been added, `false` if the element is already contained in the set.
        if (!memory.add(it)) {
            result++
            memory.remove(it)
        }
    }
    return result
}
