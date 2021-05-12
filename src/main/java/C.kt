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
}

fun initC() {
    count.clear()
}

fun runTestC(): String {
    scanner.apply {
        n = nextInt()
        val res = IntArray(n)
        val set = HashSet<Int>()



        return ""
    }
}

fun solveC(str: String) {
}
