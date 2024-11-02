import java.util.*
import kotlin.collections.HashMap
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.appendBytes
import kotlin.math.abs
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

@OptIn(ExperimentalPathApi::class)
fun runTest(test: Int, t: Int): String {
    scanner.apply {
        val n = nextInt()
        var prev = nextInt()
        var res = true
        for (i in 1 until n) {
            val a = nextInt()
            if (abs(a - prev) !in listOf(5, 7)) {
                res = false
            }
            prev = a
        }

        return if (res) "YES" else "NO"
    }
}

private fun addToSet(map: MutableMap<Int, MutableSet<Int>>, i: Int, to: Int) {
    if (i !in map) {
        map[i] = mutableSetOf(to)
    } else {
        map[i]!!.add(to)
    }
}
