import java.util.PriorityQueue
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class LeetCodeDebug {
    fun predictTheWinner(nums: IntArray): Boolean {
        val scores = Array(nums.size) {IntArray(nums.size + 1)}
        val sums = IntArray(nums.size + 1)

        for (i in 1..nums.size) scores[i - 1][i] = nums[i - 1]
        for (i in 1..nums.size) sums[i] = sums[i - 1] + nums[i - 1]

        for (len in 2..nums.size) {
            for (l in 0 until nums.size) {
                val r = l + len
                if (r > nums.size) break
                val sum1 = sums[r - 1] - sums[l]
                val sum2 = sums[r] - sums[l + 1]
                scores[l][r] = min(
                    sum2 - scores[l + 1][r] + nums[l],
                    sum1 - scores[l][r - 1] + nums[r - 1])
            }
        }

        println(scores.joinToString("\n") { it.joinToString() })
        val res = scores[0][nums.size] >= max(scores[0][nums.size - 1], scores[1][nums.size])
        return if (nums.size % 2 == 1) res else !res
    }
}


fun main() {
    val sln = { LeetCodeDebug() }
//    asrt(sln().equalSubstring("thjdoffka", "qhrnlntls", 11), 3)
    asrt(sln().predictTheWinner(intArrayOf(1, 5, 2)), false)
    asrt(sln().predictTheWinner(intArrayOf(1, 5, 233,7)), true)
}

fun asrt(b: Boolean) {
    if (!b) throw java.lang.AssertionError("Failed")
}

fun <T>asrt(a: T, b: T) {
    if (a != b) throw AssertionError("Failed: $a got, $b expected")
}
