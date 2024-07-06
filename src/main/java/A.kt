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
        val n = nextInt()
        val a = IntArray(n) { nextInt() }

        var ans = Int.MAX_VALUE
        for (i in 0 until (n - 1)) {
            ans = min(ans, max(a[i], a[i + 1]))
        }

        return "${ans - 1}"
    }
}

private fun addToSet(map: MutableMap<Int, MutableSet<Int>>, i: Int, to: Int) {
    if (i !in map) {
        map[i] = mutableSetOf(to)
    } else {
        map[i]!!.add(to)
    }
}
