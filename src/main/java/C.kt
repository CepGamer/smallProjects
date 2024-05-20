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
        val pairs = Array<MutableMap<Pair<Int, Int>, Long>>(3) { mutableMapOf() }
        val triples = mutableMapOf<Triple<Int, Int, Int>, Long>()
        var res = 0L
        val arr = IntArray(n) { nextInt() }
        var curPair = arr[0] to arr[1]

        for (i in 2 until n) {
            val (a, b) = curPair
            val c = arr[i]

            res +=
                (pairs[0][curPair] ?: 0) +
                        (pairs[1][a to c] ?: 0) +
                        (pairs[2][b to c] ?: 0) -
                        (triples[Triple(a, b, c)] ?: 0) * 3

            addOne(pairs[0], curPair)
            addOne(pairs[1], a to c)
            addOne(pairs[2], b to c)
            addOne(triples, Triple(a, b, c))
            curPair = b to c
        }

        return res.toString()
    }
}

private fun <T> addOne(to: MutableMap<T, Long>, p: T) {
    if (p in to) {
        to[p] = to[p]!! + 1L
    } else {
        to[p] = 1L
    }
}
