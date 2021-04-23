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
            println(runTestB(T, TEST))
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
        val (n, l) = nextInt() to nextInt()
        var (r, s) = nextInt() to nextInt()

        val perm = HashSet<Int>()

        for (i in (r - l) downTo 0) {
            for (j in min((s - ((i + 1) * i) / 2), n - (r - l - i)) downTo (i)) {
                if (j !in perm) {
                    perm.add(j)
                    s -= j
                    break
                }
            }
        }

        if (perm.size != r - l + 1 || s != 0) {
            return "-1"
        }
        val res = IntArray(n)
        var index = 1
        for (i in 0 until (l - 1)) {
            while (index in perm) {
                index++
            }
            res[i] = index++
        }
        var j = l - 1
        for (a in perm) {
            res[j++] = a
        }
        for (i in r until n) {
            while (index in perm) {
                index++
            }
            res[i] = index++
        }

        return res.joinToString(" ")
    }
}

fun solveB(str: String, k: Int) {
}

