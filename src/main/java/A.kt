import com.sun.org.apache.xpath.internal.operations.Bool
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.min

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

fun binarySearch(value: Int, from: Int, to: Int, valExtractor: (Int) -> Int): Int {
    var l = from
    var r = to
    var m = (l + r) / 2
    do {
        if (value > valExtractor(m)) {
            l = m
        } else
            r = m
        m = (l + r) / 2
    } while (l < r - 1)

    return l
}

fun dfs(graph: Array<ArrayList<Int>>): List<Int> {
    val visited = IntArray(graph.size)

    var fixed = false

    fun dfsInt(from: Int, to: Int): MutableList<Int> {
        if (visited[to] == 1) {
            visited[to] = 2
            return mutableListOf(to)
        } else if (visited[to] == 2) {
            return mutableListOf()
        }
        visited[to] = 1
        for (exit in graph[to]) {
            if (exit == from) {
                continue
            }
            val res = dfsInt(to, exit)
            if (res.isNotEmpty()) {
                if (visited[to] != 2 && !fixed) {
                    res.add(to)
                } else {
                    fixed = true
                }
                return res
            }
        }
        visited[to] = 2
        return mutableListOf()
    }

    val res =  dfsInt(0, 0)
    return res
}

fun bfs(queue: Queue<Int>, graph: Array<ArrayList<Int>>): IntArray {
    val res = IntArray(graph.size) { 1_000_000 }
    for (to in queue) {
        res[to] = 0
    }

    while (queue.isNotEmpty()) {
        val next = queue.poll()
        for (exit in graph[next]) {
            if (res[exit] > res[next] + 1) {
                queue.add(exit)
                res[exit] = res[next] + 1
            }
        }
    }

    return res
}

fun A() {
    scanner.apply {
        val n = nextInt()
        val graph = Array(n) { ArrayList<Int>(0) }
        for (i in 0 until n) {
            val a = nextInt()
            val b = nextInt()
            graph[a - 1].add(b - 1)
            graph[b - 1].add(a - 1)
        }

        val loop = dfs(graph)
        val res = bfs(ArrayDeque(loop), graph)

        for (i in res) {
            print("$i ")
        }
    }
}
