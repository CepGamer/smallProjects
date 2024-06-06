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
        val (n, k) = nextInt() to nextInt()
        nextLine()
        val s = nextLine()

        var cutoff = -1
        var l = n - 2

        var last = 1
        while (l >= 0 && s[l] == s[n - 1]) {
            last++
            l--
        }

        if (last > k) return "-1"
        last %= k

        l = 0
        while (l < n) {
            val a = s[l]
            var r = l
            while (++r < n && s[r] == a) {
            }
            if (r - l != k) {
                cutoff = l + (k - last)
                break
            }
            l += k
        }

        if (cutoff < 0) return "$k"

        val s1 = s.takeLast(n - cutoff) + s.take(cutoff).reversed()
        l = 0
        var a = s1[0]

        while (l < n) {
            for (i in l until l + k) {
                if (i >= n || s1[i] != a) return "-1"
            }
            l += k
            a = not(a)
        }

        return "$cutoff"

    }
}

private fun not(a: Char): Char {
    return when (a) {
        '1' -> '0'
        '0' -> '1'
        else -> 'a'
    }
}

private infix fun Int.lcd(o: Int): Int {
    var (a, b) = (max(this, o) to min(this, o))

    while (a > 0 && b > 0) {
        val t = a % b
        if (t == 0) return b

        a = b
        b = t
    }

    return 1
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
