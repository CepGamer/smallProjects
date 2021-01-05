import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

var enableDebug = false
private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

private var n: Int = 0

fun A() {
    scanner.apply {
        val T = nextInt()
        for (TEST in 1..T) {
            init()
            runTest(TEST, T)
        }
    }
}

fun init() {
}

fun runTest(test:Int, t: Int) {
    scanner.apply {
        n = nextInt()
        val x = nextInt()
        var sumDivided = 0
        var totalSum = 0L
        for (i in 0 until n) {
            val y = nextInt()
            totalSum += y
            val divRes = y / x + (if (y % x == 0) 0 else 1)
            sumDivided += divRes
        }

        println("${totalSum / x + (if (totalSum % x == 0L) 0 else 1)} $sumDivided")
    }
}

fun solve(heights: IntArray, k: Int) {
}
