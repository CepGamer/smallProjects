import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

val scanner = Scanner(System.`in`)

fun main() {
    val arr = IntArray(10000)
    val brr = IntArray(10000)
    val cycle = ArrayList<Int>(10000)
    val nums = HashSet<Int>(1000)
    scanner.apply {
        val t = nextInt()

        for (i in 1..t) {
            cycle.clear()
            nums.clear()
            val n = nextInt()
            val k = nextInt()
            for (j in 0 until n) {
                val x = nextInt()
                arr[j] = x
                if (x !in nums) {
                    nums.add(x)
                    cycle.add(x)
                }
            }
            if (nums.size > k) {
                println("-1")
                continue
            } else if (cycle.size < k) {
                for (jj in cycle.size until k)
                    cycle.add(1)
            }
            var l = 0
            var size = 0
            for (j in 0 until n) {
                while (cycle[l] != arr[j]) {
                    brr[size++] = cycle[l]
                    l = (l + 1) % cycle.size
                }
                brr[size++] = arr[j]
                l = (l + 1) % cycle.size
            }
            println(size)
            for (j in 0 until size) {
                print("${brr[j]} ")
            }
            println()
        }
    }
}
