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

        val res = Array(n) { arrayOf(0, 0) }
        res[0][0] = 1
        res[0][1] = 1
        res[n - 1] = arrayOf(n, n)

        for (i in 1 until n - 1) {
            if (i % 4 == 1) {
                res[i] = arrayOf(res[i - i / 4][0] + i, res[i - i / 4][1])
            } else if (i % 4 == 2) {
                res[i] = arrayOf(res[n - i / 4][0] - i, res[n - i / 4][1])
            } else if (i % 4 == 3) {
                res[i] = arrayOf(res[i - i / 4][0], res[0][1] + i)
            }else {
                res[i] = arrayOf(res[n - i / 4][0], res[n - i / 4][1] - i)
            }
        }

        return res.joinToString("\n") { it.joinToString(" ") }
    }
}
