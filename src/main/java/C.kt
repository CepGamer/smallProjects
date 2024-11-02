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
        val k = nextInt()

        val arr = IntArray(n) { nextInt() }
        arr.sort()
        var maxSum = IntArray(k)
        var l = 0
        var i = 0
        var a = arr[0]
        var res = 0
        var sum = 0
        var cursum = 0
        while (i < n) {
            if (arr[i] > a + 1) {
                sum = 0
                cursum = 0
            }
            a = arr[i]
            var r = 0
            while (i < n && arr[i] == a) {
                r++
                i++
            }
            sum += r
            if (cursum++ >= k) {
                sum -= maxSum[l]
            }
            maxSum[l] = r
            l = (l + 1) % k
            res = max(sum, res)
        }

        return res.toString()
    }
}

private fun lcm(a: Int): IntArray {
    val res = IntArray(21)
    var x = a

    for (i in 2..20) {
        while (x % i == 0) {
            res[i]++
            x /= i
        }
    }

    return res
}

private infix fun <T> MutableMap<T, Int>.addOne(p: T) {
    if (p in this) {
        this[p] = this[p]!! + 1
    } else {
        this[p] = 1
    }
}

private infix fun <T> MutableMap<T, Int>.remOne(p: T) {
    if (p in this) {
        this[p] = this[p]!! - 1
    } else {
        this[p] = -1
    }
}
