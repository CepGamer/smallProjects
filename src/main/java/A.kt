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
        val (_, m) = nextInt() to nextInt()
        nextLine()
        val s = nextLine()
        val count = IntArray(7)
        for (a in s) {
            count[a - 'A']++
        }

        return count.sumBy { max(0, m - it) }.toString()
    }
}
