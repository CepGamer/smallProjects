import java.util.*
import kotlin.math.max
import kotlin.math.min

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

private var n: Int = 0
private val N = 1001
private val array = IntArray(N) { 1 }

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
        n = nextInt()

        return (n - 1).toString()
    }
}

private fun gcd(x:Int, y: Int): Int {
    var (a, b) = min(x, y) to max(x, y)
    while (a > 1 && b != a) {
        val t = a
        a = b % a
        b = t
    }

    return if (a == 0) b else a
}
