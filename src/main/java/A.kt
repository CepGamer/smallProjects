import java.util.*

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
        val k = nextInt()
        val heights = IntArray(n)
        for (i in 0 until n) {
            heights[i] = nextInt()
        }
        val debug = false
        if (!debug || t < 10000)
            println(if (solve(heights, k)) "YES" else "NO")
        else if (test > 454)
            println("$n $k " + heights.joinToString(" "))
    }
}

fun solve(heights: IntArray, k: Int): Boolean {
    var top = heights[0] + k
    var bottom = heights[0]
    for (i in 1 until heights.size) {
        val height = heights[i]
        if (top < bottom || bottom >= height + 2 * k - 1 || top <= height) {
            return false
        }
        bottom = (bottom - k + 1).coerceAtLeast(height)
        top = (top - 1).coerceAtMost(height + k - 1) + k
    }

    val height = heights.last()

    return top > height && bottom - k + 1 <= height
}
