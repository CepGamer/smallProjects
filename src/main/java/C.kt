import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.HashMap
import kotlin.math.max

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

private val count = HashMap<Int, Int>()
private lateinit var arr: IntArray

private var n: Int = 0

fun C() {
    scanner.apply {
        val T = nextInt()
        for (TEST in 1..T) {
            initC()
            println(runTestC())
        }
    }
}

fun initC() {
    count.clear()
}

fun runTestC(): String {
    scanner.apply {
        n = nextInt()
        arr = IntArray(2 * n)
        for (i in 0 until 2 * n) {
            arr[i] = nextInt()
        }

        arr.sort()

        for (i in 0 until 2 * n) {
            count[arr[i]] = if (!count.containsKey(arr[i])) 1 else count[arr[i]]!! + 1
        }

        val res = dfs(2 * n - 1, -1, 0)

        if (res.size == n) {
            return "YES\n" + (res.first().first + res.first().second) + "\n" + res.joinToString("\n") { (a, b) -> "$a $b"}
        } else {
            return "NO"
        }
    }
}

fun dfs(index: Int, sum: Int, depth: Int): ArrayDeque<Pair<Int, Int>> {
    if (index < 0) {
        return ArrayDeque()
    }
    if (sum == -1) {
        for (i in 0 until index) {
            count[arr[index]] = count[arr[index]]!! - 1
            count[arr[i]] = count[arr[i]]!! - 1
            val res = dfs(if (i == index - 1) index - 2 else index - 1, arr[index], 1)
            count[arr[index]] = count[arr[index]]!! + 1
            count[arr[i]] = count[arr[i]]!! + 1
            if (res.size == n - 1) {
                res.addFirst(arr[index] to arr[i])
                return res
            }
        }
        return ArrayDeque()
    } else {
        val i = arr.binarySearch(sum - arr[index])
        if (i < 0) {
            return ArrayDeque()
        }
        count[arr[index]] = count[arr[index]]!! - 1
        count[arr[i]] = count[arr[i]]!! - 1
        if (i < 0 || count[arr[i]]!! < 0 || count[arr[index]]!! < 0) {
            count[arr[index]] = count[arr[index]]!! + 1
            count[arr[i]] = count[arr[i]]!! + 1
            return ArrayDeque()
        }
        var next = index - 1
        while (next >= 0 && count[arr[next]]!! == 0)
            next--
        val res = dfs(next, max(arr[index], arr[i]), depth + 1)
        count[arr[index]] = count[arr[index]]!! + 1
        count[arr[i]] = count[arr[i]]!! + 1
        if (depth == n - 1) {
            val deq = ArrayDeque<Pair<Int, Int>>()
            deq.add(arr[index] to arr[i])
            return deq
        } else if (!res.isEmpty()) {
            res.addFirst(arr[index] to arr[i])
        }
        return res
    }
}

fun solveC(str: String) {
}
