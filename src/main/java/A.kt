import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.math.max
import kotlin.math.min

var enableDebug = false
private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

private val edges = HashMap<Int, ArrayList<Int>>(size * 2)
private val visited = BooleanArray(size)
private val weights = LongArray(size)
private val edgeIndices = IntArray(size)
private val primes = LongArray(size)

private var n: Int = 0

var currentEdge = 0

fun A() {
    scanner.apply {
        val T = nextInt()
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
            enableDebug = n == 100_000 || true
            val l = nextInt()
            val r = nextInt()
            edges[l] = if (edges.containsKey(l)) edges[l]!! else ArrayList()
            edges[r] = if (edges.containsKey(r)) edges[r]!! else ArrayList()
            edges[l]?.add(r)
            edges[r]?.add(l)
        }

        dfs(1)

        weights.sortDescending()

        val m = nextInt()
        for (i in 0 until m) {
            primes[i] = nextInt().toLong()
        }

        primes.sortDescending()

        var result = 0L
        if (m > n - 1) {
            result = weights[0]
            for (i in 0 until m - n + 2) {
                result = result * max(primes[i], 1L) % 1000_000_007L
            }
            for (i in m - n + 2 until m) {
                result = (result + max(primes[i], 1L) * weights[i - m + n - 1]) % 1000_000_007L
            }
        }
        else {
            for (i in 0 until n - 1) {
                result = (result + max(primes[i], 1L) * weights[i]) % 1000_000_007L
            }
        }

        if (enableDebug) {
            println("$m $n ${weights[0]} ${primes[0]} ${weights[n - 15]} ${primes[m - 1]}")
            println("${weights.sum()} ${primes.sum()}")
            println(currentEdge)
        }

        println(result)
    }
}

fun dfs(current: Int): Int {
    if (visited[current]) {
        return 0
    }
    visited[current] = true

    var connections = 1

    for (i in edges[current]!!) {
        connections += dfs(i)
    }

    weights[currentEdge++] = (connections.toLong() * (n - connections).toLong())

    return connections
}
