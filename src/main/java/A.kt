import java.util.*
import kotlin.collections.HashMap
import kotlin.math.max
import kotlin.math.min

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

private var n: Int = 0
private val N = 1001
private val array = IntArray(N) { 1 }

fun A() {
    scanner.apply {
        preInit()
        val T = nextInt()
        nextLine()
        for (TEST in 1..T) {
            println(runTest(TEST, T))
        }
    }
}

fun preInit() {
}

fun init(k: Int) {
}

fun runTest(test: Int, t: Int): String {
    scanner.apply {
        val (n, m) = nextInt() to nextInt()

        val a = Array(n) { IntArray(m) { nextInt() } }
        val b = Array(n) { IntArray(m) { nextInt() } }

        val minRow = IntArray(n) { (0 until m).minOf { i -> a[it][i] } }
        val minCol = IntArray(m) { (0 until n).minOf { i -> a[i][it] } }

        if (n == 1 || m == 1) return "YES"

        val colsA = HashMap<Int, MutableSet<Int>>(m)
        val rowsA = HashMap<Int, MutableSet<Int>>(n)
        for (i in 0 until n) {
            for (j in 0 until m) {
                addToSet(colsA, minCol[j], a[i][j])
                addToSet(rowsA, minRow[i], a[i][j])
            }
        }

        // Check rows
        for (i in 0 until n) {
            val x = b[i].minOrNull()!!
            if (x !in rowsA) return "NO"
            val row = rowsA[x]!!
            for (y in b[i]) {
                if (y !in row) return "NO"
            }
        }

        // Check cols
        for (i in 0 until m) {
            val x = (0 until n).minOf { b[it][i] }
            if (x !in colsA) return "NO"
            val col = colsA[x]!!
            for (j in 0 until n) {
                val y = b[j][i]
                if (y !in col) return "NO"
            }
        }

        return "YES"
    }
}

private fun addToSet(map: MutableMap<Int, MutableSet<Int>>, i: Int, to: Int) {
    if (i !in map) {
        map[i] = mutableSetOf(to)
    } else {
        map[i]!!.add(to)
    }
}
