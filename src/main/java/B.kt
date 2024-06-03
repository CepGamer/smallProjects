import java.io.BufferedInputStream
import java.util.*
import kotlin.math.min

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

private var n: Int = 0

var debug = false

fun B() {
    scanner.apply {
        val T = nextInt()
        nextLine()

        preInitB()

        for (TEST in 1..T) {
            initB()
            println(runTestB(T, TEST))
        }
    }
}

fun preInitB() {
}

fun initB() {
}

fun runTestB(T: Int, t: Int): String {
    scanner.apply {
        val (n, m) = nextLong() to nextLong()
        val k = nextInt()

        val f = Array(k) { it to (nextLong() to nextLong()) }.sortedBy { it.second.second }.sortedBy { it.second.first }
        val minRow = LongArray(k + 1)
        val minCol = LongArray(k + 1)

        minRow[k] = n
        minCol[k] = m + 1
        minRow[k - 1] = f[k - 1].second.first
        minCol[k - 1] = f[k - 1].second.second

        for (i in (k - 2) downTo 0) {
            minRow[i] = min(minRow[i + 1], f[i].second.first)
            minCol[i] = min(minCol[i + 1], f[i].second.second)
        }

        val res = LongArray(k)
        var sum = 0L
        var prevRow = 0L
        for (i in 0..k) {
            val a = if (i < k) f[i].second.first else n
            sum += (a - prevRow) * (minCol[i] - 1)
            prevRow = a
        }

        var curCols = minCol[0]
        var curA = f[0].second.first
        for (i in 0 until k) {
            val (a, b) = f[i].second
            if (a != curA) {
                curA = a
                curCols = b
            }
            if (b < minCol[i + 1] && b == curCols) res[f[i].first] = 1
        }

        return "$sum\n" + res.joinToString(" ")
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
        while (c in '0'..'9') {
            res = (res shl 3) + (res shl 1) + (c - '0')
            c = char
        }
        return if (neg) -res else res
    }

    init {
        `in` = BufferedInputStream(System.`in`, BS)
    }
}

/*
1
2 5 9
1 2
1 5
1 1
2 2
2 4
2 5
1 4
2 3
1 3

 */
