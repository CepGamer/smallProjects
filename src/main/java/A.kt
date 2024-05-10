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
        val (k, q) = nextInt() to nextInt()

        val a = IntArray(k + 1) { if (it == 0) 0 else nextInt() }
        val b = IntArray(k + 1) { if (it == 0) 0 else nextInt() }

        val result = StringBuilder()
        for (i in 1..q) {
            val p = nextInt()
            val t1 = a.binarySearch(p)
            val r = if (t1 >= 0) t1 else t1.inv() - 1

            if (r >= k) {
                result.append(b[r])
            } else {
                result.append(b[r] + ((p.toLong() - a[r]) * (b[r + 1].toLong() - b[r])) / (a[r + 1].toLong() - a[r]))
            }
            result.append(' ')
        }

        return result.toString()
    }
}
