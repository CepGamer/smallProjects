import java.util.*
import kotlin.collections.HashSet
import kotlin.math.abs

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
        val squares = HashSet<Int>()
        val points = HashSet<Int>()
        for (i in 1..n) {
            val x = nextInt()
            for (point in points) {
                squares.add(abs(x - point))
            }

            points.add(x)
        }

        println(squares.size)
    }
}

fun solve(heights: IntArray, k: Int) {
}
