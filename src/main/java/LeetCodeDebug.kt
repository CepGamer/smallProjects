import java.util.PriorityQueue
import kotlin.math.abs
import kotlin.math.min

class LeetCodeDebug {
    fun maximumSafenessFactor(grid: List<List<Int>>): Int {
        val thieves = findThieves(grid)
        val safeGrid = setSafeness(grid, thieves)

        return pathSearch(safeGrid, 0 to 0, (grid.size - 1) to (grid[0].size - 1))
    }

    fun findThieves(grid: List<List<Int>>): Set<Pair<Int, Int>> {
        val res = mutableSetOf<Pair<Int, Int>>()
        for (i in grid.indices) {
            for (j in 0 until grid[i].size) {
                if (grid[i][j] == 1) {
                    res += i to j
                }
            }
        }

        return res
    }

    fun setSafeness(grid: List<List<Int>>, thieves: Set<Pair<Int, Int>>): List<IntArray> {
        val res = ArrayList<IntArray>(grid.size)
            .apply { for (i in grid.indices) add(IntArray(grid[0].size) { Int.MAX_VALUE }) }
        for (i in grid.indices) {
            for (j in 0 until grid[0].size) {
                for ((x, y) in thieves) {
                    res[i][j] = min(res[i][j], abs(i - x) + abs(j - y))
                }
            }
        }

        return res
    }

    fun pathSearch(grid: List<IntArray>, start: Pair<Int, Int>, finish: Pair<Int, Int>): Int {
        val vis = ArrayList<BooleanArray>(grid.size)
            .apply { for (i in grid.indices) add(BooleanArray(grid[0].size)) }

        val queue = PriorityQueue<Pair<Int, Int>> { (a, b), (x, y) ->
            grid[x][y] - grid[a][b]
        }
        queue.add(start)

        var minMax = Int.MAX_VALUE
        while (queue.isNotEmpty()) {
            val (x, y) = queue.remove()
            minMax = min(minMax, grid[x][y])

            if (finish == x to y) {
                break
            }
            vis[x][y] = true

            queue.addAll(getNeighbours(x to y, grid.size, grid[0].size).filter { (a, b) -> !vis[a][b] }
                .map { (a, b) -> vis[a][b] = true; a to b })
        }

        return minMax
    }

    fun dfs(grid: List<IntArray>, p: Pair<Int, Int>, vis: List<BooleanArray>, fin: Pair<Int, Int>): Int {
        val (x, y) = p

        if (vis[x][y] || p == fin) {
            return grid[x][y]
        }

        vis[x][y] = true

        val safeness = grid[x][y]
        return min(safeness, getNeighbours(p, grid.size, grid[0].size).maxOf { dfs(grid, it, vis, fin) })
    }

    fun getNeighbours(p: Pair<Int, Int>, n: Int, m: Int): List<Pair<Int, Int>> {
        val (x, y) = p
        return listOf(x + 1 to y, x - 1 to y, x to y + 1, x to y - 1)
            .filter { (a, b) -> a in 0 until n && b in 0 until m }
    }
}


fun main() {
    val sln = { LeetCodeDebug() }
    asrt(sln().maximumSafenessFactor(listOf(listOf(0, 1, 1), listOf(0, 1, 1), listOf(1, 1, 1))), 0)
    asrt(sln().maximumSafenessFactor(listOf(listOf(0, 0, 1), listOf(0, 0, 0), listOf(0, 0, 0))), 2)
    asrt(sln().maximumSafenessFactor(listOf(listOf(0, 0, 0, 1), listOf(0, 0, 0, 0), listOf(1, 0, 0, 0))), 2)
}

fun runTest(input: List<List<Int>>, result: Int) {
    val sln = LeetCodeDebug()

    asrt(sln.maximumSafenessFactor(input), result)
}

fun asrt(b: Boolean) {
    if (!b) throw java.lang.AssertionError("Failed")
}

fun asrt(a: Int, b: Int) {
    if (a != b) throw AssertionError("Failed: $a got, $b expected")
}
