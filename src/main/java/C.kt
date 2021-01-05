import java.util.*

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

val modulo = 1_000_000_000L + 7L

private var n: Int = 0

fun C() {
    scanner.apply {
        val T = nextInt()
        for (TEST in 1..T) {
            initC()
            runTestC()
        }
    }
}

fun initC() {
}

fun findComponent(connected: IntArray, j: Int): Int {
    if (connected[j] != connected[connected[j]]) {
        connected[j] = findComponent(connected, connected[j])
    }
    return connected[j]
}

fun runTestC() {
    scanner.apply {
        val n = nextInt()
        val m = nextInt()
        val costs = IntArray(n)
        val presents = IntArray(m)

        for (i in 0 until n) {
            costs[i] = nextInt()
        }

        costs.sort()

        for (i in 0 until m) {
            presents[i] = nextInt()
        }

        var j = 0
        var totalCost = 0L
        for (i in (n - 1) downTo 0) {
            val cur = presents[costs[i] - 1]
            totalCost += if (j < costs[i]) {
                presents[j++]
            } else cur
        }

        println(totalCost)
    }
}

fun solveC(str: String) {
}
