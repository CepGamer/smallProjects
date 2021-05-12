import java.io.BufferedInputStream
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.math.*

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

private var n: Int = 0

private lateinit var Int: BooleanArray
private lateinit var edges: Array<ArrayDeque<Int>>

private lateinit var divisors: Array<ArrayDeque<Int>>
private lateinit var divisorByInt: List<Pair<Int, ArrayDeque<Int>>>

private lateinit var dynamic: BooleanArray

var debug = false

fun B() {
    scanner.apply {
        val T = nextInt()

        preInitB()

        for (TEST in 1..T) {
            initB()
            print(runTestB(T, TEST))
        }
    }
}

class FastScanner {
    private val BS = 1 shl 16
    private val NC = 0.toChar()
    private val buf = ByteArray(BS)
    private var bId = 0
    private var size = 0
    private var c = NC
    private var `in`: BufferedInputStream? = null

    private val char: Char
        get() {
            while (bId == size) {
                size = try {
                    `in`!!.read(buf)
                } catch (e: Exception) {
                    return NC
                }
                if (size == -1) return NC
                bId = 0
            }
            return buf[bId++].toChar()
        }

    fun nextInt(): Int {
        var neg = false
        if (c == NC) c = char
        while (c < '0' || c > '9') {
            if (c == '-') neg = true
            c = char
        }
        var res = 0
        while (c >= '0' && c <= '9') {
            res = (res shl 3) + (res shl 1) + (c - '0')
            c = char
        }
        return if (neg) -res else res
    }

    init {
        `in` = BufferedInputStream(System.`in`, BS)
    }
}

fun preInitB() {
}

fun initB() {
}

fun runTestB(T: Int, t: Int): String {
    scanner.apply {
        n = nextInt()
        val arr = IntArray(n)
        for (i in 0 until n) {
            arr[i] = nextInt()
        }

        if (n < 2) {
            return "0"
        }

        val builder = StringBuilder()
        builder.appendLine(n / 2 + n % 2)

        var i = 1
        while (i < n) {
            var minA = min(arr[i], arr[i - 1])
            var maxA = minA + (minA % 2 + 1)
            if (i + 1 < n) {
                if (maxA == arr[i + 1]) {
                    maxA += 2
                }
            }
            if (i - 2 >= 0) {
                if (arr[i - 2] == minA) {
                    val t = minA
                    minA = maxA
                    maxA = t
                }
            }
            builder.appendLine("$i ${i + 1} $minA $maxA")

            arr[i] = maxA

            i += 2
        }

        if (n % 2 == 1) {
            val minA = min(arr[n - 1], arr[n - 2])
            if (n - 3 >= 0 && arr[n - 3] == minA) {
                builder.appendLine("${n - 1} $n ${minA + (minA % 2 + 1)} $minA")
            } else {
                builder.appendLine("${n - 1} $n $minA ${minA + (minA % 2 + 1)}")
            }
        }

        return builder.toString()
    }
}

fun gcd(a: Int, b: Int): Int {
    var (l, r) = min(a, b) to max(a, b)
    while (l > 1) {
        val a = l
        l = r % l
        r = a
    }

    return r
}

fun solveB(str: String, k: Int) {
}

