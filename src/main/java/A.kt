import java.util.*

private val scanner = Scanner(System.`in`)
private val size = 2 * 100_000 + 10

fun A() {
    scanner.apply {
        val arr = IntArray(size)
        val subarrs = TreeMap<Int, TreeMap<Int, Int>>()
        val t = nextInt()
        for (TEST in 1..t) {
            val n = nextInt()
            for (i in 0 until n) {
                arr[i] = 0
            }
            subarrs[n] = TreeMap()
            subarrs[n]?.set(1, n)
            var action = 1
            while (subarrs.isNotEmpty()) {
                val largestArrs = subarrs[subarrs.lastKey()]!!
                val firstArr = largestArrs.firstEntry()
                largestArrs.remove(firstArr.key)
                if (largestArrs.isEmpty()) {
                    subarrs.remove(subarrs.lastKey())
                }

                val (l,r) = (firstArr.key to firstArr.value)
                if ((r - l + 1) % 2 == 1) {
                    arr[(l + r) / 2 - 1] = action
                    val (ll, lr) = l to (l + r) / 2 - 1
                    val (rl, rr) = (l + r) / 2 + 1 to r
                    if (ll <= lr) {
                        var tree = subarrs[lr - ll + 1]
                        if (tree == null) {
                            tree = TreeMap()
                        }
                        tree[ll] = lr
                        subarrs[lr - ll + 1] = tree
                    }
                    if (rl <= rr) {
                        var tree = subarrs[rr - rl + 1]
                        if (tree == null) {
                            tree = TreeMap()
                        }
                        tree[rl] = rr
                        subarrs[rr - rl + 1] = tree
                    }
                } else {
                    arr[(l + r - 1) / 2 - 1] = action
                    val (ll, lr) = l to (l + r - 1) / 2 - 1
                    val (rl, rr) = (l + r - 1) / 2 + 1 to r
                    if (ll <= lr) {
                        var tree = subarrs[lr - ll + 1]
                        if (tree == null) {
                            tree = TreeMap()
                        }
                        tree[ll] = lr
                        subarrs[lr - ll + 1] = tree
                    }
                    if (rl <= rr) {
                        var tree = subarrs[rr - rl + 1]
                        if (tree == null) {
                            tree = TreeMap()
                        }
                        tree[rl] = rr
                        subarrs[rr - rl + 1] = tree
                    }
                }
                action++
            }
            for (i in 0 until n) {
                print("${arr[i]} ")
            }
            println()
        }
    }
}
