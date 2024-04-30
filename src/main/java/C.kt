import java.util.*
import kotlin.math.abs
import kotlin.math.min

private val scanner = Scanner(System.`in`)

private lateinit var arr: IntArray

fun main() {
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
        val (n, k) = nextInt() to nextLong()
        val arr = LongArray(n) { nextLong() }

        var kk = k
        arr.sort()
        var minVal = arr[0]
        var (l, r) = 0 to 1
        while (l < n && r < n) {
            while (r < n && arr[l] == arr[r]) {
                r++
            }
            l = r

            val coef = if (r >= n) kk / r else min(kk / r, arr[r] - arr[0])
            kk -= r * coef
            arr[0] += coef

            if (kk < r) break
        }

        if (kk > n) {
            arr[0] += kk / n
            kk %= n
        }

        l = 0
        while (l < n) {
            if (arr[0] < arr[l]) break
            l++
        }

        if (l < n) kk += n - l

        return ((arr[0] - 1) * (n - 1) + arr[0] + kk).toString()
    }
}
