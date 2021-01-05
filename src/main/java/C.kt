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

        var j = m - 1
        var totalCost = 0L
        for (i in (n - 1) downTo 1) {
            val cur = costs[i]
            val next = costs[i - 1]
            while (j > 0 && cur > presents[j]) {
                j--
            }
            while (j > 0 && cur <= presents[j] && presents[j] > next) {
                j--
            }
            j++

            totalCost += if (presents[j] > 0 && presents[j] < cur) {
                presents[j] *= -1
                -presents[j]
            } else cur
        }

        val cost = if (presents[0] > 0 && presents[0] < costs[0]) presents[0] else costs[0]

        println(cost)
    }
}

fun solveC(str: String) {
}
