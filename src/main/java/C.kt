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
        val T = nextInt()
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
        val a = nextInt()
        val b = nextInt()
        n = nextInt()

        val boys = IntArray(n)
        val girls = IntArray(n)

        for (i in 0 until n) {
            boys[i] = nextInt()
        }
        for (i in 0 until n) {
            girls[i] = nextInt()
        }

        if (a < 2 || b < 2 || n < 2) {
            return "0"
        }

        var res = 0
        for (i in 0 until n) {
            val boy = boys[i]
            val girl = girls[i]
            res += (n - 1)
            for (j in 0 until n) {
                if (i == j) {
                    continue
                }
                if (boys[j] == boy || girls[j] == girl) {
                    res--
                }
            }
        }

        return (res / 2).toString()
    }
}

fun solveC(str: String) {
}
