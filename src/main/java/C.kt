import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.HashMap
import kotlin.collections.HashSet
import kotlin.math.max

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

private val count = HashMap<Int, Int>()
private lateinit var arr: IntArray

private var n: Int = 0

private var map = HashMap<Int, Int>()

fun C() {
    scanner.apply {
        preInitC()
        val T = nextInt()
        for (TEST in 1..T) {
            initC()
            println(runTestC())
        }
    }
}

fun preInitC() {
    for (i in 1..100_000) {
        var c = 0
        var j = 1
        var x = i
        while (j * j <= i) {
            if (i % j == 0) {
                c += j
                if (i / j != j) c += i / j
            }
            j++
        }

        if (c !in map)
            map[c] = i
        if (c > 10_000_000) {
            break
        }
    }
}

fun initC() {
    count.clear()
}

fun runTestC(): String {
    scanner.apply {
        val c = nextInt()

        return if (c in map) map[c].toString() else "-1"
    }
}

fun solveC(str: String) {
}
