import java.util.*

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
        val k = nextInt()
        val heights = IntArray(n)
        for (i in 0 until n) {
            heights[i] = nextInt()
        }
        println(if (solveB(heights, k)) "YES" else "NO")
    }
}

fun solveB(heights: IntArray, k: Int): Boolean {
    var lo = heights[0]
    var ok = true
    var hi = lo
    for (j in 1 until n) {
        val height = heights[j]
        lo = Math.max(lo - k + 1, height)
        hi = Math.min(hi + k - 1, height + k - 1)
        if (lo > hi) {
            ok = false
        }
        if (j == n - 1 && lo != height) {
            ok = false
        }
    }

    return ok
}
