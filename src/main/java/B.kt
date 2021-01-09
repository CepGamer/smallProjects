import java.io.BufferedInputStream
import java.lang.StringBuilder
import kotlin.collections.ArrayDeque
import kotlin.math.*

private val scanner = FastScanner()
private val size = 100_000 + 10

private var n: Int = 0

private lateinit var Int: BooleanArray
private lateinit var edges: Array<ArrayDeque<Int>>

var debug = false

fun B() {
    scanner.apply {
        val T = nextInt()

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

fun initB() {
}

fun runTestB(T: Int, t: Int): String {
    scanner.apply {
        n = nextInt()

        val arr = IntArray(n)
        for (i in 0 until n) {
            arr[i] = nextInt()
        }

        var count = 0
        val hillsOrValleys = IntArray(n)
        for (i in 1 until (n - 1)) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                hillsOrValleys[i] = 1
                count++
            }
            if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                hillsOrValleys[i] = 1
                count++
            }
        }

        val isHillOrValley = { i: Int ->
            if (i <= 0 || i >= n - 1) 0
            else if ((arr[i - 1] < arr[i] && arr[i + 1] < arr[i]) || (arr[i - 1] > arr[i] && arr[i + 1] > arr[i])) 1 else 0
        }

        var res = count

        for (i in 1 until (n - 1)) {
            val tmp = arr[i]
            arr[i] = arr[i - 1]
            res = arrayOf(res, count - hillsOrValleys[i - 1] - hillsOrValleys[i] - hillsOrValleys[i + 1]
             + isHillOrValley(i - 1) + isHillOrValley(i) + isHillOrValley(i + 1)).minOrNull()!!

            arr[i] = arr[i + 1]
            res = arrayOf(res, count - hillsOrValleys[i - 1] - hillsOrValleys[i] - hillsOrValleys[i + 1]
                    + isHillOrValley(i - 1) + isHillOrValley(i) + isHillOrValley(i + 1)).minOrNull()!!

            arr[i] = tmp
        }

        return res.toString()
    }
}

fun solveB(str: String, k: Int) {
}
