import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.math.max
import kotlin.math.min

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

private var n: Int = 0

fun B() {
    scanner.apply {
        val T = 1//nextInt()

        for (TEST in 1..T) {
            initB()
            runTestB()
        }
    }
}

fun initB() {
}

fun runTestB() {
    scanner.apply {
        n = nextInt()
        val m = nextLong()
        nextLine()
        val s = nextLine()

        println(if (solveB(m.toLong(), s)) "Yes" else "No")
    }
}

fun solveB(number: Long, string: String): Boolean {
    val digits = IntArray(26)
    var res = 0L

    res += pow(2L, string[string.length - 1] - 'a')
    res -= pow(2L, string[string.length - 2] - 'a')

    if (string.length == 2) {
        return res == number
    }

    for (c in string.substring(0, string.length - 2)) {
        digits[c - 'a']++
    }

    for (i in 25 downTo 0) {
        var x = digits[i]
        while (x > 0) {
            val value = pow(2L, i)
            if (res > number) {
                res -= value
            } else {
                res += value
            }

            x--
        }
    }

    return res == number
}

fun pow(x: Long, deg: Int): Long {
    var dg = deg
    var res = x
    var tail = 1L
    if (deg == 0) {
        return 1
    } else if (deg == 1) {
        return x
    }

    while (dg > 0) {
        if (dg % 2L == 1L) {
            tail *= res
        }

        res *= res
        dg /= 2
    }

    return tail
}
