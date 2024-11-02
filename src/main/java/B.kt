import java.io.BufferedInputStream
import java.util.*
import kotlin.math.min

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 1
val modulo = 1_000_000_000 + 7

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
        val (n, k) = nextInt() to nextInt()
        val res = IntArray(k + 1)
        for (i in 0 until k) {
            val (b, c) = nextInt() to nextInt()
            res[b] += c
        }
        res.sortDescending()

        var rr = 0L
        for (i in 0 until min(n, k)) {
            rr += res[i]
        }

        return rr.toString()
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
