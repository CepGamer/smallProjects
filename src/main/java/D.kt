import java.io.BufferedInputStream
import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.HashMap
import kotlin.math.max
import kotlin.math.min

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

private var n: Int = 0

private lateinit var Int: BooleanArray
private lateinit var edges: Array<ArrayDeque<Int>>

private lateinit var divisors: Array<ArrayDeque<Int>>
private lateinit var divisorByInt: List<Pair<Int, ArrayDeque<Int>>>

private lateinit var dynamic: BooleanArray

fun D() {
    scanner.apply {
        val T = nextInt()
        nextLine()

        for (TEST in 1..T) {
            println(runTestD(T, TEST))
        }
    }
}

private fun runTestD(T: Int, t: Int): String {
    scanner.apply {
        val n = nextInt()
        val a = LongArray(n) { nextLong() }
        var c = 0
        var res = 0L

        while (c < n) {
            while (c < n && a[c] == 0L) c++
            if (c >= n) break

            var rc = c + 1
            var acc = a[c]
            while (rc < n && a[rc] != 0L) {
                acc += a[rc]
                rc++
            }
            val maxVals = Array(rc - c) { a[c + it] to c + it }
            maxVals.sortBy { it.first }

            val l = rc - c
            res += when {
                l == 1 -> a[c]
                l % 2 == 0 -> acc * 2
                else -> {
                    var k = 0L
                    for (i in (maxVals.size - 1) downTo 0) {
                        val (x, j) = maxVals[i]
                        if ((j - c) % 2 == 0) {
                            k = (acc - x) * 2 + x
                            break
                        }
                    }
                    k
                }
            }
            c = rc
        }

        return res.toString()
    }
}

class FastScannerD {
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
