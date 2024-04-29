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
        nextLine()
        for (TEST in 1..T) {
            initC()
            println(runTestC())
        }
    }
}

fun preInitC() {
}

fun initC() {
    count.clear()
}

fun runTestC(): String {
    scanner.apply {
        val s = nextLine()

        val map = hashMapOf<Char, Long>()
        s.forEach {
            map[it] = (map[it] ?: 0) + 1
        }

        if (map.keys.size < 2) {
            return "YES"
        }

        for (key in map.keys) {
            if (map[key]!! > 1) {
                return "NO"
            }
        }

        return "YES"
    }
}

fun solveC(str: String) {
}
