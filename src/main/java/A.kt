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
        n = nextInt()
        nextLine()
        val s = nextLine()
        val res = StringBuilder(n)
        var last = if (s[0] == '0') '1' else '2'
        res.append('1')
        for (i in 1 until n) {
            val b = s[i]
            val c = when (last) {
                '1' ->
                    if (b == '1') {
                        last = '2'
                        '1'
                    } else {
                        last = '0'
                        '0'
                    }
                '2' -> {
                    last = '1'
                    if (b == '1') '0' else '1'
                }
                '0' -> {
                    last = if (b == '0') '1' else '2'
                    '1'
                }
                else -> '0'
            }
            res.append(c)
        }

        return res.toString()
    }
}

fun solve(heights: IntArray, k: Int) {
}
