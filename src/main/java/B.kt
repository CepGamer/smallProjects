import java.io.BufferedInputStream
import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.HashMap
import kotlin.math.floor
import kotlin.math.sqrt

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
        val n = nextInt()
        nextLine()

        val s = nextLine()
        val a = IntArray(26)
        for (c in s) {
            a[c - 'a']++
        }
        val rb = StringBuilder()
        var l = 0
        for (i in 0 until 26) {
            if (a[i] > 0) {
                rb.append('a' + i)
                a[i] = l++
            }
        }
        val r = rb.toString()

        val rs = StringBuilder()
        for (c in s) {
            rs.append(r[r.length - a[c - 'a'] - 1])
        }

        return rs.toString()
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
