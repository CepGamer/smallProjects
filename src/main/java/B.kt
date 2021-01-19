import java.io.BufferedInputStream
import java.lang.StringBuilder
import kotlin.collections.ArrayDeque
import kotlin.math.*

private val scanner = FastScanner()
private val size = 100_000 + 10

private var n: Int = 0

private lateinit var Int: BooleanArray
private lateinit var edges: Array<ArrayDeque<Int>>

private lateinit var divisors: Array<ArrayDeque<Int>>
private lateinit var divisorByInt: List<Pair<Int, ArrayDeque<Int>>>

private lateinit var sieve: BooleanArray

var debug = false

fun B() {
    scanner.apply {
        val T = nextInt()

        preInitB()

        val stringResult = StringBuilder()

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
    sieve = BooleanArray(30_000 + 10) { true }
    val isPrime = { a: Int ->
        var res = true
        var j = 3
        while (j * j <= a) {
            if (a % j == 0)
                res = false

            j += 2
        }

        res
    }

    for (i in 2 until 15_000 + 10) {
        if (!sieve[i])
            continue
        var a = i + i
        while (a < 30_000 + 10) {
            sieve[a] = false
            a += i
        }
    }
}

fun initB() {
}

fun runTestB(T: Int, t: Int): String {
    scanner.apply {
        n = nextInt()

        val isPrime = { a: Int ->
            if (a < 30_000 + 10) {
                sieve[a]
            } else {
                var res = true
                var j = 3
                while (j * j <= a) {
                    if (a % j == 0)
                        res = false

                    j += 2
                }

                res
            }
        }

        for (i in (1 + n)..30_000 + 10) {
            if (!isPrime(i))
                continue
            for (j in (i + n)..30_000 + 10) {
                if (!isPrime(j))
                    continue
                if (i - 1 >= n && j - i >= n && i * j >= n) {

                    return (i * j).toString()
                }
            }
        }

        return "1"
    }
}

fun solveB(str: String, k: Int) {
}
