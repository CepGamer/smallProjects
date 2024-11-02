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

private fun runTestD(T: Int, t: Int): String = scanner.run {
    val (m, n) = nextInt() to nextInt()
    nextLine()
    val carpet = Array(m) { nextLine() }
    var (sa, sb) = 0 to 0
    var res = 0
    while (sa < m / 2 && sb < n / 2) {
        val s = StringBuilder()
        var index = 0
        val arr = CharArray(4)
        var (x, y) = sa to sb
        while (y < n - sb) {
            arr[index % 4] = carpet[x][y]
            s.append(carpet[x][y])
            index++
            y++
        }
        y--
        x++
        while (x < m - sa) {
            arr[index % 4] = carpet[x][y]
            s.append(carpet[x][y])
            index++
            x++
        }
        x--
        y--
        while (y >= sb) {
            arr[index % 4] = carpet[x][y]
            s.append(carpet[x][y])
            index++
            y--
        }
        y++
        x--
        while (x > sa) {
            arr[index % 4] = carpet[x][y]
            s.append(carpet[x][y])
            index++
            x--
        }

        for (i in s.indices) {
            val b = if (i + 4 >= s.length) s.substring(0, (i + 4) % s.length) else ""
            val x = s.substring(i, min(s.length, i + 4)) + b
            if (x == "1543") res++
        }
        sa++
        sb++
    }

    res.toString()
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
