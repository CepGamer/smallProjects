import java.util.*
import kotlin.math.*

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

private var n: Int = 0

fun C() {
    scanner.apply {
        val T = 1//nextInt()
        for (TEST in 1..T) {
            initC()
            println(runTestC())
        }
    }
}

fun initC() {
}

fun runTestC(): String {
    scanner.apply {
        val sizes = IntArray(3)
        for (i in 0 until 3) {
            sizes[i] = nextInt()
        }

        val bags = Array(3) { LongArray(sizes[it]) }

        for (s in 0 until 3) {
            for (i in 0 until sizes[s]) {
                bags[s][i] = nextLong()
            }
        }

        bags.forEach { it.sort() }

        val calculate = {
            val res = bags[0].sum()
            val (m1, m2) = bags[1][0] to bags[2][0]
            val (s1, s2) = bags[1].takeLast(sizes[1] - 1).sum() to bags[2].takeLast(sizes[2] - 1).sum()

            res + arrayOf(m1 - m2 - s2 + s1, m2 + s2 - m1 - s1, s1 + s2 - m1 - m2).maxOrNull()!!
        }
        var res = calculate()

        val tmpb1 = bags[0]
        bags[0] = bags[1]
        bags[1] = tmpb1
        val tmps1 = sizes[0]
        sizes[0] = sizes[1]
        sizes[1] = tmps1

        res = max(res, calculate())

        val tmpb2 = bags[0]
        bags[0] = bags[2]
        bags[2] = tmpb2
        val tmps2 = sizes[0]
        sizes[0] = sizes[2]
        sizes[2] = tmps2

        res = max(res, calculate())

        return res.toString()
    }
}

fun solveC(str: String) {
}
