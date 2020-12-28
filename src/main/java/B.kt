import java.util.*
import kotlin.math.max

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

private var n: Int = 0

fun B() {
    scanner.apply {
        val T = nextInt()

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
        val r = IntArray(n)
        for (i in 0 until n) {
            r[i] = nextInt()
        }

        val m = nextInt()
        val b = IntArray(m)
        for (i in 0 until m) {
            b[i] = nextInt()
        }

        println(solveB(r, b))
    }
}

fun solveB(r: IntArray, b: IntArray): Int {
    var curMax = 0
    var totMax = 0

    val rmax = r.fold(0 to 0) { acc, i -> max(acc.first, acc.second + i) to acc.second + i }.first
    val bmax = b.fold(0 to 0) { acc, i -> max(acc.first, acc.second + i) to acc.second + i }.first

    return rmax + bmax
}
