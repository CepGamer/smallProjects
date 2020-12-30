import java.util.*
import kotlin.collections.HashSet
import kotlin.math.abs

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

private var n: Int = 0

var debug = false

fun B() {
    scanner.apply {
        val T = nextInt()

        for (TEST in 1..T) {
            initB()
            runTestB(T, TEST)
        }
    }
}

fun initB() {
}

fun runTestB(T: Int, t: Int) {
    scanner.apply {
        n = nextInt()
        val notes = IntArray(n)
        for (i in 0 until n) {
            notes[i] = nextInt()
        }

        var lastAdded = notes[0]
        var res = 1
        for (i in 1 until (n)) {
            if (notes[i] > lastAdded) {
                res++
                lastAdded = notes[i]
            } else if (notes[i] + 1 != lastAdded) {
                res++
                lastAdded = notes[i] + 1
            }
        }

        println((res).coerceAtMost(n))
    }
}

fun solveB(str: String, k: Int) {
}
