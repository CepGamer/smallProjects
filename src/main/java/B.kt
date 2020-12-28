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
    var i = 0
    var j = 0

    while (true) {
        if (i >= r.size && j >= b.size) {
            return totMax
        }
        if (j >= b.size || r[i] > b[j]) {
            curMax += r[i]
            i++
        } else {
            curMax += b[j]
            j++
        }
        totMax = max(totMax, curMax)
    }
}
