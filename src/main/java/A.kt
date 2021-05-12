import java.lang.StringBuilder
import java.util.*

var enableDebug = false
private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

private var n: Int = 0
private val N = 5_000 + 1
private val array = IntArray(N)
private val count = IntArray(N)
private val isEqual0 = BooleanArray(N)

val modulo = 1000_000_000L + 7L

val paths = Array(N) { LongArray(N) }
val times = LongArray(N)

fun A() {
    scanner.apply {
        preInit()
        val T = nextInt()
        for (TEST in 1..T) {
            println(runTest(TEST, T))
        }
    }
}

fun preInit() {
}

fun init(k: Int) {
}

fun runTest(test: Int, t: Int): String {
    scanner.apply {
        val a = nextLong()
        val b = nextLong()

        if (b == 1L) {
            return "NO"
        }

        val res = LongArray(3)
        res[0] = a * b
        res[1] = a
        res[2] = res[0] + res[1]
        return "YES\n" + res.joinToString(" ") + "\n"
    }
}

fun solve(heights: IntArray, k: Int) {
}
