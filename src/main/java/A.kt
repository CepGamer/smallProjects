import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max
import kotlin.math.min

var enableDebug = false
private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

private val edges = ArrayList<Pair<Int, Int>>(size * 2)
private val visited = BooleanArray(size)
private val weights = LongArray(size)
private val edgeIndices = IntArray(size)
private val primes = LongArray(size)

private var n: Int = 0

var currentEdge = 0

fun A() {
    scanner.apply {
        val T = nextInt()
        if (T == 100) {
            enableDebug = true
        }
        for (TEST in 1..T) {
            init()
            runTest()
        }
    }
}

fun init() {
    edges.clear()
    visited.fill(false)
    weights.fill(0)
    edgeIndices.fill(size)
    primes.fill(0)
    currentEdge = 0
}

fun runTest() {
    scanner.apply {
        n = nextInt()
        for (i in 1 until n) {
            val l = nextInt()
            val r = nextInt()
            edges.add(l to r)
            edges.add(r to l)
        }

        edges.sortBy { it.first }
        for (i in 0 until (n * 2 - 2)) {
            edgeIndices[edges[i].first] = min(edgeIndices[edges[i].first], i)
        }
        edgeIndices[n + 1] = n * 2 - 2

        dfs(1)

        weights.sortDescending()

        val m = nextInt()
        for (i in 0 until m) {
            primes[i] = nextInt().toLong()
            if (enableDebug) {
                print("${primes[i]} ")
            }
        }

        primes.sortDescending()

        if (m > n - 1) {
            primes[0] = primes.take(m - n + 2).reduce { a, b -> a * b % 1000_000_007L}
            for (i in 1 until n - 1) {
                primes[i] = primes[i + m - n + 1]
            }
        }

        var result = 0L
        for (i in 0 until n - 1) {
            result += (max(primes[i], 1) * weights[i]) % 1000_000_007L
        }

        println(result % 1000_000_007L)
    }
}

fun dfs(current: Int): Int {
    if (visited[current]) {
        return 0
    }
    visited[current] = true

    var connections = 1

    for (i in edgeIndices[current] until min(edgeIndices[current + 1], edges.size)) {
        connections += dfs(edges[i].second)
    }

    weights[currentEdge++] = (connections * (n - connections)).toLong()

    return connections
}
