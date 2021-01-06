import java.io.BufferedInputStream
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

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
            stringResult.appendLine(runTestB(T, TEST))
        }

        print(stringResult)
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
        val m = nextInt()

        val visited = IntArray(n + 1)
        edges = Array(n + 1) { ArrayDeque() }

        for (i in 1..m) {
            val a = nextInt()
            val b = nextInt()
            edges[a].add(b)
            edges[b].add(a)
        }

        val next = ArrayDeque<Int>(n + 1)
        next.addLast(1)
        var blacks = 0
        var seen = 0
        val result = ArrayList<Int>(n)
        while (!next.isEmpty()) {
            val v = next.removeFirst()
            if (visited[v] and 2 != 0) {
                continue
            }
            visited[v] = visited[v] or 2
            val isCurrentWhite = visited[v] and 1 != 0
            if (!isCurrentWhite) {
                result.add(v)
                blacks++
            }
            seen++
            if (edges[v].isEmpty())
                break
            val neighbours = edges[v]
            while (!neighbours.isEmpty()) {
                val u = neighbours.removeLast()
                if (!isCurrentWhite) {
                    visited[u] = visited[u] or 1
                    next.addLast(u)
                } else {
                    next.addFirst(u)
                }
            }
        }

        if (seen == n) {
            return StringBuilder().append("YES\n$blacks\n").append(result.joinToString(" ")).toString()
        } else {
            return "NO"
        }
    }
}

fun solveB(str: String, k: Int) {
}
