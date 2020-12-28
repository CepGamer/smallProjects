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
        println(solve(heights, k))
    }
}

fun solve(heights: IntArray, k: Int): Boolean {
    val top = heights[0] + k
    val bottom = heights[0]
    for (i in 1 until heights.size) {
        val height = heights[i]

    }
    return false
}
