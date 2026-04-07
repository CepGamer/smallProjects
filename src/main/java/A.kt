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
//        val T = nextInt()
//        nextLine()
//        for (TEST in 1..T) {
//            println(runTest(TEST, T))
//        }
        println(runTest(0, 0))
    }
}

fun preInit() {
}

fun init(k: Int) {
}

@OptIn(ExperimentalPathApi::class)
fun runTest(test: Int, t: Int): String = scanner.run {
    val n = nextInt()
    val k = nextInt()
    val q = nextInt()
    val countries = Array(n) { IntArray(k) { nextInt() } }
    for (i in 1 until n) {
        for (j in 0 until k) {
            countries[i][j] = countries[i - 1][j] or countries[i][j]
        }
    }

    val res = StringBuilder()
    for (x in 0 until q) {
        val m = nextInt()
        var (rx, ry) = 0 to n - 1
        for (i in 0 until m) {
            val a = nextInt() - 1
            val sign = next("[<>]")
            val b = nextInt()
            if (sign == ">") {
                var l = -1
                var r = n
                while (l + 1 < r) {
                    val m = (l + r) ushr 1
                    if (countries[m][a] > b) {
                        r = m
                    } else {
                        l = m
                    }
                }

                rx = max(rx, r)
            } else {
                var l = -1
                var r = n
                while (l + 1 < r) {
                    val m = (l + r) ushr 1
                    if (countries[m][a] >= b) {
                        r = m
                    } else {
                        l = m
                    }
                }
                ry = min(ry, r - 1)
            }
        }
        res.append(if (rx <= ry) {
            (rx + 1).toString()
        } else "-1")
        res.append("\n")
    }

    res.toString()
}

private fun addToSet(map: MutableMap<Int, MutableSet<Int>>, i: Int, to: Int) {
    if (i !in map) {
        map[i] = mutableSetOf(to)
    } else {
        map[i]!!.add(to)
    }
}
