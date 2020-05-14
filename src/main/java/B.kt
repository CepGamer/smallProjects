import java.lang.StringBuilder
import java.util.*
import kotlin.math.min

private val scanner = Scanner(System.`in`)
private val size = 1_000_000 + 10

fun solve(str: String, ones: Int): Int {
    var res = ones
    val dp = IntArray(str.length)
    var pref = 0
    for (i in str.indices) {
        val char = str[i].toInt() - '0'.toInt()
        pref += char
        dp[i] = 1 - char
        if (i > 0) {
            dp[i] = dp[i] + min(dp[i - 1], pref - char)
        }
        res = min(res, dp[i] + ones - pref)
    }

    return res
}

fun main() {
    scanner.apply {
        val arr = IntArray(size)
        val t = nextInt()
        for (TEST in 1..t) {
            val n = nextInt()
            val k = nextInt()
            val sums = ArrayList<StringBuilder>(k)
            val s = next()
            for (i in 0 until k) {
                sums.add(StringBuilder(s[i].toString()))
            }
            for (index in k until n) {
                sums[index % k].append(s[index])
            }
            var min = 1000000000
            val allOnes = s.count { it == '1' }
            for (str in sums.map { it.toString() }) {
                val ones = str.count { it == '1' }
                min = min(min, solve(str, ones) + allOnes - ones)
            }
            println(min)
        }
    }
}
