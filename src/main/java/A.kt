import java.lang.StringBuilder
import java.util.*
import kotlin.math.max
import kotlin.math.min

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
        nextLine()
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
        val a = nextLine()

        val sumFun = { sum: Long, c: Char -> sum + (c - 'a' + 1) }

        if (a.length % 2 == 0) {
            return "Alice ${a.fold(0L, sumFun)}"
        }

        val (left, lb) = a.take(a.length - 1).fold(0L, sumFun) to (a.last() - 'a' + 1)
        val (right, rb) = a.takeLast(a.length - 1).fold(0L, sumFun) to (a[0] - 'a' + 1)

        if (left > lb || right > rb) {
            return "Alice ${max(left, right) - min(lb, rb)}"
        } else {
            return "Bob ${max(lb, rb) - min(left, right)}"
        }
    }
}

fun solve(heights: IntArray, k: Int) {
}
