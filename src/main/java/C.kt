import java.util.*
import kotlin.math.abs
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
        val (n, k) = nextInt() to nextInt()
        arr = IntArray(n) { nextInt() }
        val modified = BooleanArray(n)
        val queue = TreeMap<Int, MutableSet<Int>>()

        for (i in 0 until n - 1) {
            val diff = abs(arr[i] - arr[i + 1])
            addToQueue(queue, diff, i)
        }

        for (i in 0 until k) {
            if (queue.size == 0) {
                break
            }
            val entry = queue.lastEntry()
            val big = entry.value.minOrNull()!!
            entry.value.remove(big)

            if (entry.value.size == 0) {
                queue.remove(entry.key)
            }

            val m = min(arr[big], arr[big + 1])
            if (big > 0) {
                val key = abs(arr[big] - arr[big - 1])
                queue[key]?.remove(big)
                addToQueue(queue, abs(m - arr[big - 1]), big - 1)

                if (queue[key]?.size == 0) {
                    queue.remove(key)
                }
            }

            if (big + 2 < arr.size) {
                val key = abs(arr[big + 1] - arr[big + 2])
                queue[key]?.remove(big + 1)
                addToQueue(queue, abs(m - arr[big + 2]), big + 1)

                if (queue[key]?.size == 0) {
                    queue.remove(key)
                }
            }
            arr[big] = m
            arr[big + 1] = m
            modified[big] = true
        }

        var min = if (modified[0]) arr[0] else Int.MAX_VALUE
        for (i in 0 until n) {
            if (!modified[i]) {
                min = Int.MAX_VALUE
                continue
            } else {
                min = min(min, arr[i])
                arr[i] = min
            }
        }

        return arr.fold(0L, Long::plus).toString()
    }
}

fun addToQueue(queue: TreeMap<Int, MutableSet<Int>>, diff: Int, i: Int) {
    if (diff in queue) {
        queue[diff]?.plusAssign(i)
    } else {
        queue[diff] = mutableSetOf(i)
    }

}
