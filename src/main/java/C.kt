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
        val arr = IntArray(n) { nextInt() }
        val cycle = HashMap<Int, MutableList<Int>>()

        for (i in arr.indices) {
            val x = arr[i] shr 2
            if (x !in cycle) {
                cycle[x] = mutableListOf()
            }
            cycle[x]!!.add(i)
        }

        for (c in cycle.values) {
            if (c.size > 1) {
                val nums = IntArray(c.size) { arr[c[it]] }.sorted()
                var j = 0
                for (i in c) {
                    arr[i] = nums[j++]
                }
            }
        }

        return arr.joinToString(" ")
    }
}
