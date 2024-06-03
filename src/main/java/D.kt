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
        val a = IntArray(n) { nextInt() }
        val lcds = IntArray(n - 1)
        for (i in 1 until n) {
            lcds[i - 1] = a[i - 1] lcd a[i]
        }

        val restIsNonDesc = BooleanArray(n - 1)
        restIsNonDesc[n - 2] = true
        for (i in n - 3 downTo 0) {
            if (lcds[i + 1] >= lcds[i]) restIsNonDesc[i] = true
            else {
                restIsNonDesc[i] = false
                break
            }
        }

        var isNonDesc = true
        if (restIsNonDesc[1]) return "YES"

        for (i in 1 until (n - 1)) {
            val x = (a[i - 1] lcd a[i + 1])
            val leftOk = isNonDesc && (i == 1 || x >= lcds[i - 2])
            val rightOk = (i == n - 2 || restIsNonDesc[i + 1]) && (i == n - 2 || x <= lcds[i + 1])
            if (leftOk && rightOk) return "YES"

            if (i > 1 && lcds[i - 1] < lcds[i - 2]) isNonDesc = false
        }

        return if (isNonDesc) "YES" else "NO"

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
