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
        var mmin = 5
        var a = 0

        while (a <= 25) {
            if (a > n) {
                break
            }

            mmin = min(mmin, (n - a) % 3)
            a += 5
        }

        return mmin.toString()
    }
}
