import java.util.*
import kotlin.collections.HashMap
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.appendBytes
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
        val s = nextLine()
        val t = nextLine()
        var res = 0
        for (i in 0 until min(s.length, t.length)) {
            if (s[i] != t[i]) {
                break
            }
            res++
        }

        return "${s.length + t.length - max(0, res - 1)}"
    }
}

private fun addToSet(map: MutableMap<Int, MutableSet<Int>>, i: Int, to: Int) {
    if (i !in map) {
        map[i] = mutableSetOf(to)
    } else {
        map[i]!!.add(to)
    }
}
