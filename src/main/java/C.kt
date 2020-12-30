import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList
import kotlin.math.*

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

val modulo = 1_000_000_000L + 7L

private var n: Int = 0

fun C() {
    scanner.apply {
        val T = 1//nextInt()
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

        val connected = IntArray(m + 1) { it }
        val res = ArrayList<Int>(n)
        var curGroup = 0

        for (i in 1..n) {
            val k = nextInt()
            val m1 = nextInt()
            val m2 = if (k == 2) nextInt() else 0
            val a = findComponent(connected, connected[m1])
            val b = findComponent(connected, connected[m2])
            if (a != b) {
                connected[a] = b
                res.add(i)
            }
        }
        var resNum = 1L
        for (i in 1..res.size) {
            resNum = (2L * resNum) % modulo
        }

        println("$resNum ${res.size}")
        println(res.joinToString(" "))
    }
}

fun solveC(str: String) {
}
