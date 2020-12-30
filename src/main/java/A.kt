import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

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
        val used = BooleanArray(n)
        val queue = PriorityQueue<Int>(n)
        var sum = 0L
        for (i in 0 until n) {
            weights[i] = Int.MAX_VALUE - nextInt()
            sum += Int.MAX_VALUE - weights[i]
        }
        for (i in 0 until (n - 1)) {
            val u = nextInt() - 1
            val v = nextInt() - 1
            if (used[u]) {
                queue.add(weights[u])
            }
            if (used[v]) {
                queue.add(weights[v])
            }
            used[u] = true
            used[v] = true
        }

        print("$sum ")

        while (queue.isNotEmpty()) {
            val x = queue.remove()
            sum += (Int.MAX_VALUE - x)
            print("$sum ")
        }

        println()
    }
}

fun solve(heights: IntArray, k: Int) {
}
