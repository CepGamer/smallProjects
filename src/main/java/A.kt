import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet
import kotlin.math.abs

var enableDebug = false
private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

private var n: Int = 0

fun A() {
    scanner.apply {
        val T = nextInt()
        for (TEST in 1..T) {
            init()
            runTest(TEST, T)
        }
    }
}

fun init() {
}

fun runTest(test:Int, t: Int) {
    scanner.apply {
        n = nextInt()
        val weights = IntArray(n)
        for (i in 0 until n) {
            weights[i] = nextInt()
        }
        val edges = HashMap<Int, ArrayList<Int>>()
        for (i in 0 until (n - 1)) {
            val u = nextInt()
            val v = nextInt()

            if (!edges.containsKey(u)) {
                edges[u] = ArrayList()
            }
            edges[u]!!.add(v)

            if (!edges.containsKey(v)) {
                edges[v] = ArrayList()
            }
            edges[v]!!.add(u)
        }
    }
}

fun solve(heights: IntArray, k: Int) {
}
