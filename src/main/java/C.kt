import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt
import kotlin.math.sqrt

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

private var n: Int = 0

fun C() {
    scanner.apply {
        val T = nextInt()

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
        solveC()
        println()
    }
}

fun solveC() {
    val jin = BufferedReader(InputStreamReader(System.`in`))
    val out = StringBuilder()
    val (n, k) = jin.readLine().split(" ").map { it.toInt() }
    val s = listOf(0) + jin.readLine().map { it - '0' }
    val sums = IntArray(n + 1)
    for (j in 1..n) {
        sums[j] = sums[j - 1] + s[j]
    }
    var banned = mutableSetOf<Int>()
    var curr = 0
    for (e in 0 until min(20, k) - 1) {
        curr += (1 - s[min(20, k) - 1 - e]) shl e
    }
    for (j in k..n) {
        curr = ((curr shl 1) + (1 - s[j])) and ((1 shl min(20, k)) - 1)
        if (k <= 20 || sums[n - 20] - sums[n - k] == k - 20) {
            banned.add(curr)
        }
    }
    if (k <= 20 && banned.size == 1 shl k) {
        out.appendln("NO")
    } else {
        out.appendln("YES")
        val answer = (0 until (1 shl min(20, k))).first { it !in banned }
        if (k > 20) {
            out.append("0".repeat(k - 20))
        }
        out.appendln((answer + (1 shl min(20, k))).toString(2).substring(1))
    }

    print(out)
}
