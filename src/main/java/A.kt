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
        val T = 1//nextInt()
        for (TEST in 1..T) {
            println(runTest(TEST, T))
        }
    }
}

fun preInit() {
    for (i in 0 until N) {
        paths[i][0] = 1
    }
}

fun init(k: Int) {
    for (i in 1 until N) {
        paths[0][i] = paths[1][i - 1]
        paths[n - 1][i] = paths[n - 2][i - 1]
        for (j in 1 until (n - 1)) {
            paths[j][i] = (paths[j - 1][i - 1] + paths[j + 1][i - 1]) % modulo
            if (paths[j][i] < 0) paths[j][i] += modulo
        }
    }
    for (i in 0 until n) {
        for (j in 0..k) {
            times[i] += paths[i][j] * paths[i][k - j]
        }
        times[i] %= modulo
        if (times[i] < 0) times[i] += modulo
    }
}

fun runTest(test: Int, t: Int): String {
    scanner.apply {
        n = nextInt()
        val k = nextInt()
        val q = nextInt()

        init(k)

        var res = 0L
        val arr = LongArray(n)
        for (i in 0 until n) {
            arr[i] = nextLong()
            res += arr[i] * times[i]
            res %= modulo
            if (res < 0) res += modulo
        }

        val stringBuilder = StringBuilder()
        for (i in 0 until q) {
            val (j, a) = nextInt() - 1 to nextLong()
            res -= (arr[j] * times[j])
            arr[j] = a
            res += a * times[j]
            res %= modulo
            if (res < 0) {
                res += modulo
            }
            stringBuilder.appendLine(res)
        }

        return stringBuilder.toString()
    }
}

fun solve(heights: IntArray, k: Int) {
}
