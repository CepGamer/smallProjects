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

fun runTest(test:Int, t: Int): String {
    scanner.apply {
        n = nextInt()

        val b = "9012345678".repeat(n/ 10 + 1)

        val res = "98$b"

        return res.take(n)
    }
}

fun solve(heights: IntArray, k: Int) {
}
