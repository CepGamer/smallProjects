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
        val b = IntArray(n) { nextInt() }
        val m = nextInt()
        val d = IntArray(m) { nextInt() }

        if (d.last() !in b) return "NO"

        val missing = mutableMapOf<Int, Int>()

        for (i in 0 until n) {
            if (a[i] != b[i]) missing addOne b[i]
        }

        for (x in d) {
            missing remOne x
        }

        return if (missing.values.all { it <= 0 }) "YES" else "NO"
    }
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
