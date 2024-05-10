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
        val n = nextLong()
        val (lower, upper) = n * n to (n + 1) * (n + 1)

        var acc = 0
        var y = n

        for (x in 1L..n) {
            while (x * x + y * y >= upper) y--
            while (y >= 0 && x * x + y * y in lower until upper) {
                acc += 4
                y--
            }
            y++
        }

        return (acc).toString()
    }
}

val results = HashMap<String, Boolean>()

fun step(coins: String): Boolean {
    if (!coins.contains("U")) {
        return false
    }

    if (coins in results) {
        return results[coins]!!
    }

    for (i in coins.indices) {
        if (coins[i] == 'U') {
            val builder = StringBuilder(coins)

            builder[(coins.length + i - 1) % coins.length] = replace(builder[(coins.length + i - 1) % coins.length])
            builder[(coins.length + i + 1) % coins.length] = replace(builder[(coins.length + i + 1) % coins.length])

            if (!step(builder.removeRange(i, i + 1).toString())) {
                results[coins] = true
                return true
            }
        }
    }

    results[coins] = false
    return false
}

fun replace(c: Char) = if (c == 'D') 'U' else 'D'

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
