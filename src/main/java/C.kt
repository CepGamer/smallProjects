import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.*

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

private var n: Int = 0

fun C() {
    scanner.apply {
        val T = nextInt()
        nextLine()
        for (TEST in 1..T) {
            initC()
            runTestC()
        }
    }
}

fun initC() {
}

fun runTestC() {
    scanner.apply {
        val s = nextLine()
        println(solveC(s))
    }
}

fun solveC(str: String): Int {
    val locations = IntArray(26)
    locations.fill(-10)
    val digitizedString = str.map { it - 'a' }
    var res = 0
    if (digitizedString.size == 1) {
        return 0
    }
    locations[digitizedString[0]] = 0
    for (i in 1 until digitizedString.size) {
        var c = digitizedString[i]
        val old = locations[c]
        val oldI = c
        if (i - locations[c] <= 2) {
            res++

            for (j in 0 until 26) {
                if (abs(i - locations[j]) <= 2) {
                    continue
                }
                if (i + 1 < digitizedString.size && digitizedString[i + 1] == j) {
                    continue
                }
                if (i + 2 < digitizedString.size && digitizedString[i + 2] == j) {
                    continue
                }
                c = j
            }
        }
        locations[oldI] = old
        locations[c] = i
    }

    return res
}
