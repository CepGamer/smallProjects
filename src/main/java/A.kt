import java.util.*

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

fun A() {
    println(findMedianSortedArrays(intArrayOf(), intArrayOf(1, 2, 3, 4, 5)))
    println(findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(5, 7)))
    println(findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2)))
    println(findMedianSortedArrays(intArrayOf(1, 3, 4), intArrayOf(5, 7, 9, 11)))
    println(findMedianSortedArrays(intArrayOf(1, 3), intArrayOf()))
    println(findMedianSortedArrays(intArrayOf(0, 0), intArrayOf(0, 0)))
    println(findMedianSortedArrays(intArrayOf(1), intArrayOf(1)))
    println(findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(1, 2, 3)))
    println(findMedianSortedArrays(intArrayOf(), intArrayOf(1, 2, 3)))
    println(findMedianSortedArrays(intArrayOf(100001), intArrayOf(100000)))
}


fun lengthOfLongestSubstring(s: String): Double {
    val lastIndex = hashMapOf<Char, Int>()
    var minRange = 0
    var curRange = 0
    for (i in s.indices) {
        val c = s[i]
        if (lastIndex.contains(c)) {
            val lastEntry = lastIndex[c]!!
            if (i - lastEntry > curRange) {
                curRange++
            } else {
                curRange = i - lastEntry
            }
            lastIndex[c] = i
        } else {
            lastIndex[c] = i
            curRange++
        }

        minRange = Integer.max(minRange, curRange)
    }

    return minRange.toDouble()
}
fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val size = nums1.size + nums2.size
    var left = 0
    var right = 0
    val last = IntArray(2)
    if (nums1.size == 0) {
        val i = size / 2 + size % 2
        val shift = (size / 2) % 2
        if (size == 1)
            return nums2[0].toDouble()
        return getRes(intArrayOf(nums2[i - (1 - shift)], nums2[i - shift]), size)
    } else if (nums2.size == 0) {
        val i = size / 2 + size % 2
        val shift = (size / 2) % 2
        if (size == 1)
            return nums1[0].toDouble()
        return getRes(intArrayOf(nums1[i - (1 - shift)], nums1[i - shift]), size)
    }

    for (i in 0 until ((size + 2) / 2)) {
        if (nums2.size == right || (nums1.size > left && nums1[left] <= nums2[right])) {
            last[i % 2] = nums1[left++]
        } else {
            last[i % 2] = nums2[right++]
        }
    }

    return getRes(last, size)
}

fun getRes(last: IntArray, size: Int): Double {
    if (size % 2 == 1) {
        return last[(size / 2) % 2].toDouble()
    } else {
        return (last.sum()).toDouble() / 2.0
    }
}

inline fun max(a: Long, b: Long, s: String): Long {
    if (a > b)
        return a
    else return b
}
//4.0
//2.0
//5.0
//2.0
//0.0
//1.0
//2.0
