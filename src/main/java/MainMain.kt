import java.util.*

fun main() {
    runTest(intArrayOf(1, 2, -1000_000, 3, -1000_000), doubleArrayOf(0.0, 0.0, 1.5, 0.0, 2.0))
    runTest(intArrayOf(-1, -1000_000, -2, -1000_000, -3, -1000_000, -4, -1000_000, -5, -1000_000),
        doubleArrayOf(0.0, -1.0, 0.0, -1.5, 0.0, -2.0, 0.0, -2.5, 0.0, -3.0))
}

fun runTest(input: IntArray, result: DoubleArray) {
    val sln = Solution()

    for (i in input.indices) {
        val a = input[i]
        if (a == -1000_000) {
            asrt(kotlin.math.abs(sln.findMedian() - result[i]) <= 0.00001)
        } else {
            sln.addNum(a)
        }
    }
}

fun asrt(b: Boolean) {
    if (!b) throw java.lang.AssertionError("Failed")
}

fun asrt(a: Int, b: Int) {
    if (a != b) throw AssertionError("Failed: $a got, $b expected")
}

class Solution {
    val left = TreeMap<Int, Int>().apply { this[-1000_000] = 1 }
    val right = TreeMap<Int, Int>().apply { this[1000_000] = 1 }
    var m = -1000_000

    private fun TreeMap<Int, Int>.decrement(a: Int) {
        if (a in this) {
            if (this[a] == 1) this.remove(a) else this[a] = this[a]!! - 1
        }
    }

    fun addNum(num: Int) {
        if (m == -1000_000) {
            if (left.lastKey() < num) {
                right.increment(num)
                m = right.firstKey()!!
                right.decrement(m)
            } else {
                left.increment(num)
                m = left.lastKey()
                left.decrement(m)
            }
        } else {
            if (m < num) {
                right.increment(num)
                left.increment(m)
            } else {
                left.increment(num)
                right.increment(m)
            }
            m = -1000_000
        }
     }

    private fun TreeMap<Int, Int>.increment(a: Int) {
        if (a in this) this[a] = this[a]!! + 1 else this[a] = 1
    }

    fun findMedian(): Double {
        return if (m != -1000_000) m.toDouble()
        else (left.lastKey() + right.firstKey()).toDouble() / 2.0
    }
}
