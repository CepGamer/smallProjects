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
        val n = nextInt()
        val b = LongArray(n + 2)

        val max2 = LongArray(2)

        b[0] = nextLong()
        b[1] = nextLong()
        max2[0] = b[0]
        max2[1] = b[1]
        max2.sort()

        for (i in 2 until (n + 2)) {
            b[i] = nextLong()
            if (b[i] > max2[0]) {
                max2[0] = b[i]
                max2.sort()
            }
        }

        var s = max2[0]
        var ss = s
        var max = max2[1]
        val mx = max
        for (i in 0 until (n + 2)) {
            var rm = false
            for (j in 0 until 2) {
                if (b[i] == max2[j]) {
                    rm = true
                    max2[j] = -1
                    break
                }
            }
            if (!rm) {
                s -= b[i]
                ss += b[i]
            }
        }
        val builder = StringBuilder()
        if (s == 0L) {
            for (i in 0 until n) {
                builder.append(b[i])
                builder.append(' ')
            }

            return builder.toString()
        }

        val d = ss - max
        var excl = -1
        for (i in 0 until n + 1) {
            if (b[i] != max && b[i] == d) {
                excl = i
                break
            }
        }

        return if (excl == -1) "-1" else {
            for (i in 0 until n + 2) {
                if (i == excl || b[i] == max) {
                    if (b[i] == max) max = -1
                    continue
                }
                else {
                    builder.append(b[i])
                    builder.append(' ')
                }
            }
            builder.toString()
        }
    }
}

fun solve(heights: IntArray, k: Int) {
}
