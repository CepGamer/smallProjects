import java.util.*
import kotlin.math.max
import kotlin.math.min

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

private var n: Int = 0
private val N = 50 + 1
private val array = IntArray(N)

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
        val arr = IntArray(n) {nextInt()}
        val brr = IntArray(n) {nextInt()}

        var (a, b) = n - 1 to n - 1
        var acc = 0

        while (a >= 0 && b >= 0) {
            if (brr[b] >= arr[a]) {
                a--
                b--
            } else {
                a--
                acc++
            }
        }

        return acc.toString()
    }
}

fun solve(heights: IntArray, k: Int) {
}
