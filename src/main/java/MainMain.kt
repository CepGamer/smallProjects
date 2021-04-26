import java.lang.AssertionError
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet
import kotlin.math.max

private val scanner = Scanner(System.`in`)

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
fun main() {
    val sln = Solution()

    asrt(sln.maximumSwap(2736), 7236)
    asrt(sln.maximumSwap(9973), 9973)
    asrt(sln.maximumSwap(1), 1)
    asrt(sln.maximumSwap(10), 10)
    asrt(sln.maximumSwap(101), 110)
    asrt(sln.maximumSwap(12345), 52341)
    asrt(sln.maximumSwap(98368), 98863)
    asrt(sln.maximumSwap(0), 0)
    asrt(sln.maximumSwap(100000010), 110000000)
}

fun asrt(a: Int, b: Int) {
    if (a != b) throw AssertionError("Failed: $a got, $b expected")
}

class Solution {
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        var sums = IntArray(2000 + 10)
        var sums2 = IntArray(2000 + 10)

        sums[nums[0] + 1000]++
        sums[-nums[0] + 1000]++
        for (ai in 1 until nums.size) {
            val a = nums[ai]
            for (i in 0..2001) {
                if (sums[i] != 0) {
                    sums2[a + i] += sums[i]
                    sums2[-a + i] += sums[i]
                }
            }

            val arr = sums
            sums = sums2
            sums2 = arr
            sums2.fill(0)
        }

        return sums[target + 1000]
    }

    fun maximumSwap(num: Int): Int {
        var a = 1
        var dgs = 0
        val string = IntArray(10)
        val maxVal = IntArray(10)
        while (a < num) {
            string[dgs] = getDigit(num, dgs++)
            a *= 10
        }

        maxVal[0] = string[0]
        for (i in 1 until 10) {
            maxVal[i] = max(maxVal[i - 1], string[i])
        }

        string[dgs] = getDigit(num, dgs--)

        var i = dgs
        while (i >= 1) {
            if (string[i] < maxVal[i]) {
                for (j in 0 until i) {
                    if (string[j] == maxVal[i]) {
                        val a = string[i]
                        string[i] = string[j]
                        string[j] = a
                    }
                }
                break
            }
            i--
        }

        return string.foldRight(0) { a, acc -> acc * 10 + a }
    }

    fun getDigit(num: Int, digit: Int): Int {
        var dg = digit
        var n = num
        while (dg > 0) {
            dg--
            n /= 10
        }

        return n % 10
    }
}
