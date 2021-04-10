import java.io.BufferedInputStream
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayDeque
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
        n = nextInt()
        nextLine()

        val square = Array<Pair<Int, Int>>(4) { 0 to 0 }
        var index = 0

        for (i in 0 until n) {
            val s = nextLine()
            for (j in 0 until n) {
                val c = s[j]
                if (c == '*') {
                    square[index++] = i to j
                }
            }
        }

        if (square[0].first == square[1].first) {
            val x = if (square[1].first < n - 1) square[1].first + 1 else 0
            square[2] = (x) to square[1].second
            square[3] = (x) to square[0].second
        } else if (square[0].second == square[1].second) {
            val x = if (square[1].second < n - 1) square[1].second + 1 else 0
            square[2] = square[0].first to (x)
            square[3] = square[1].first to (x)
        } else {
            square[2] = square[0].first to square[1].second
            square[3] = square[1].first to square[0].second
        }

        val builder = StringBuilder()
        for (i in 0 until n) {
            for (j in 0 until n) {
                var pr = false
                for (a in square) {
                    if (i == a.first && j == a.second) {
                        builder.append('*')
                        pr = true
                        break
                    }
                }
                if (!pr) {
                    builder.append('.')
                }
            }

            if (i != n - 1) builder.append('\n')
        }

        return builder.toString()
    }
}

fun solveB(str: String, k: Int) {
}

