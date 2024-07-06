import java.util.*
import kotlin.collections.HashMap
import kotlin.math.max
import kotlin.math.min

private val scanner = Scanner(System.`in`)

private lateinit var arr: IntArray

fun C() {
    scanner.apply {
        val T = nextInt()
        nextLine()
        for (TEST in 1..T) {
            println(runTestC())
        }
    }
}

fun runTestC(): String {
    scanner.apply {
        val n = nextInt()
        val a = IntArray(n) { nextInt() }

        if (a.all { it > n }) return "1 ".repeat(n)

        val l = a.map(::lcm)
        val p = IntArray(21)
        for (i in 2..20) {
            p[i] = l.maxOf { it[i] }
        }

        var x = 1L
        for (i in 2..20) {
            while (p[i]-- > 0) {
                x *= i
            }
        }
        val lcm = x
        val b = a.map { lcm / it }
        val s = b.sum()

        if (lcm <= s) return "-1"

        return b.joinToString(" ")
    }
}

private fun lcm(a: Int): IntArray {
    val res = IntArray(21)
    var x = a

    for (i in 2..20) {
        while (x % i == 0) {
            res[i]++
            x /= i
        }
    }

    return res
}

private infix fun <T> MutableMap<T, Int>.addOne(p: T) {
    if (p in this) {
        this[p] = this[p]!! + 1
    } else {
        this[p] = 1
    }
}

private infix fun <T> MutableMap<T, Int>.remOne(p: T) {
    if (p in this) {
        this[p] = this[p]!! - 1
    } else {
        this[p] = -1
    }
}
