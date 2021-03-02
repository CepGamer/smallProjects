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

fun C() {
    scanner.apply {
        val T = 1 //nextInt()
        for (TEST in 1..T) {
            initC()
            println(runTestC())
        }
    }
}

fun initC() {
    count.clear()
}

fun runTestC(): String {
    scanner.apply {
        n = nextInt()
        val met = HashMap<Int, Int>()

        for (i in 0 until n) {
            val a = nextInt()
            met[a] = i
        }

        return "${met.keys.size}\n" + met.keys.sortedBy { met[it] }.joinToString(" ")
    }
}

fun solveC(str: String) {
}
