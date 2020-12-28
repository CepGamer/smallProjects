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
    var i = 0
    var j = 0

    val maxSubSumsR = IntArray(r.size)
    val maxSubSumsB = IntArray(b.size)

    for (i in (r.size - 1) downTo 0) {
        maxSubSumsR[i] = totMax
        curMax = max(0, curMax + r[i])
    }

    curMax = 0
    totMax = 0

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
