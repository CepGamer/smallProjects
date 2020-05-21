import java.util.*

private val scanner = Scanner(System.`in`)
private val size = 10_000 + 10

class Circle(val x: Int, val r: Int, val i: Int) {
    var isHit = -1

    fun tryHit(p: Pair<Int, Int>, shotNum: Int) {
        val dx = p.first - x
        val dy = p.second
        if (isHit == -1 && dx * dx + dy * dy <= r * r) {
            isHit = shotNum
        }
    }
}

fun findIfHit(arr: Array<Circle>, p: Pair<Int, Int>, n: Int, shotNum: Int) {
    val x = p.first

    var l = 0
    var r = n - 1

    while (r - l > 1) {
        val m = (l + r) / 2
        val c = arr[m]
        if (c.x > x) {
            r = m
        } else {
            l = m
        }
    }
    arr[l].tryHit(p, shotNum)
    arr[r].tryHit(p, shotNum)
}

fun B() {
    scanner.apply {
        val n = nextInt()
        val arr = Array(n) { Circle(0, 0, 0) }
        for (i in 0 until n) {
            arr[i] = Circle(nextInt(), nextInt(), i)
        }
        arr.sortBy { it.x }
        val m = nextInt()
        for (i in 1..m) {
            val x = nextInt()
            val y = nextInt()
            findIfHit(arr, x to y, n, i)
        }

        arr.sortBy { it.i }
        println(arr.count { it.isHit != -1 })
        for (i in 0 until n) {
            print("${arr[i].isHit} ")
        }
    }
}
