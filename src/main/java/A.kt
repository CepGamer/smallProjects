import java.lang.StringBuilder
import java.util.*
import kotlin.math.max

var enableDebug = false
private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

private var n: Int = 0
private val N = 1_000_000 + 10
private val array = IntArray(N)
private val count = IntArray(N)
private val isEqual0 = BooleanArray(N)

val modulo = 1000_000_000L + 7L

fun A() {
    scanner.apply {
        preInit()
        val T = nextInt()
        for (TEST in 1..T) {
            init()
            println(runTest(TEST, T))
        }
    }
}

fun preInit() {
}

fun init() {
}

fun runTest(test: Int, t: Int): String {
    scanner.apply {
        n = nextInt()
        val k = nextInt()
        val q = nextInt()

        val arr = LongArray(n)
        for (i in 0 until n) {
            arr[i] = nextLong()
        }

        val times = Array(n) { LongArray(k) }

        for (i in 0 until n) {
            var sum = arr[i]
            times[i][0] = sum
            for (j in 1 until k) {

            }
        }

        return ""
    }
}

fun solve(heights: IntArray, k: Int) {
}
