fun main() {
    val sln = Solution()

    asrt(sln.minEatingSpeed(intArrayOf(1, 2), 2), 2)
    asrt(sln.minEatingSpeed(intArrayOf(1, 5), 2), 5)
    asrt(sln.minEatingSpeed(intArrayOf(1, 5), 5), 2)
    asrt(sln.minEatingSpeed(intArrayOf(1, 5), 6), 1)
    asrt(sln.minEatingSpeed(intArrayOf(3, 6, 7, 11), 8), 4)
    asrt(sln.minEatingSpeed(intArrayOf(30, 11, 23, 4, 20), 5), 30)
    asrt(sln.minEatingSpeed(intArrayOf(30, 11, 23, 4, 20), 6), 23)
}

fun asrt(a: Int, b: Int) {
    if (a != b) throw AssertionError("Failed: $a got, $b expected")
}

class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        val maxSpeed = piles.maxOrNull() ?: 1000_000_000

        var (l, r) = 1 to maxSpeed + 1

        while (l + 1 <= r) {
            val m = (l + r) / 2

            if (countTime(piles, m) <= h) {
                r = m
            } else {
                l = m + 1
            }
        }

        return l
    }

    fun countTime(piles: IntArray, speed: Int): Int {
        return piles.map { it / speed + (if (it % speed > 0) 1 else 0) }.sum()
    }
}
