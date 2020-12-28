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
            runTest()
        }
    }
}

fun init() {
}

fun runTest() {
    scanner.apply {
        n = nextInt()
        val k = nextInt()
        val heights = IntArray(n)
        for (i in 0 until n) {
            heights[i] = nextInt()
        }
        println(if (solve(heights, k)) "YES" else "NO")
    }
}

fun solve(heights: IntArray, k: Int): Boolean {
    var top = heights[0] + k - 1
    var bottom = heights[0]
    for (i in 1 until (heights.size - 1)) {
        val height = heights[i]
        top = (top + k - 1).coerceAtMost(height + k - 1)
        bottom = (bottom - k + 1).coerceAtLeast(height)
        if (top <= bottom) return false
    }

    val height = heights.last()

    return top + k - 1 >= height && bottom - k + 1 <= height
}
