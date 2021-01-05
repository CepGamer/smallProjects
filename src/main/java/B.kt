import java.util.*
import kotlin.collections.ArrayList

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
        val x = nextInt()
        var sum = 0L
        val afterSum = ArrayList<Pair<Int, Int>>(10 * n)

        var i = 0
        var stopped = false
        while (i < n) {
            val num = nextInt()
            if (!stopped && num % x == 0) {
                afterSum.add(num / x to x)
            } else {
                stopped = true
            }

            sum += num

            i++
        }

        i = 0
        while (i < afterSum.size) {
            val (num, times) = afterSum[i]
            sum += num * times
            if (!stopped && num % x == 0) {
                afterSum.add(num / x to times * x)
            } else {
                stopped = true
            }
            i++
        }

        println(sum)
    }
}

fun solveB(str: String, k: Int) {
}
