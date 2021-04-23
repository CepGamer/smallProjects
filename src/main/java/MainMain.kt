import java.lang.AssertionError
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

private val scanner = Scanner(System.`in`)

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
fun main() {
    val sln = Solution()

    asrt(sln.findTargetSumWays(intArrayOf(1,1,1,1,1), 3), 5)
    asrt(sln.findTargetSumWays(intArrayOf(1), 1), 1)
    asrt(sln.findTargetSumWays(intArrayOf(1,1,1), 1), 3)
    asrt(sln.findTargetSumWays(intArrayOf(1, 2, 3), 3), 0)
    asrt(sln.findTargetSumWays(intArrayOf(1), -1), 1)
    asrt(sln.findTargetSumWays(intArrayOf(2,107,109,113,127,131,137,3,2,3,5,7,11,13,17,19,23,29,47,53),132), 2248)
    asrt(sln.findTargetSumWays(intArrayOf(0,1),1), 2)
    asrt(sln.findTargetSumWays(intArrayOf(0,0,0,0,0,0,0,0,1),1), 256)
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
}
