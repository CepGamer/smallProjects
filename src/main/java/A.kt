import com.sun.org.apache.xpath.internal.operations.Bool
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max
import kotlin.math.min

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10


fun printTable(n: Int, k: Int) {
    val table = Array(n) { IntArray(n) }
    var counter = 0
    var x = 0
    var y = 0
    for (i in 0 until k) {
        table[x++ % n][y++ % n] = 1
        counter++
        if (counter % n == 0) {
            x++
        }
    }

    val rmax = table.maxBy { it.sum() }?.sum() ?: 0
    val rmin = table.minBy { it.sum() }?.sum() ?: 0
    var cmax = 0
    var cmin = 1000_000
    for (i in 0 until n) {
        var sum = 0
        for (j in 0 until n) {
            sum += table[i][j]
        }
        cmax = max(sum, cmax)
        cmin = min(sum, cmin)
    }

    println((cmax - cmin) * (cmax - cmin) + (rmax - rmin) * (rmax - rmin))
    for (i in 0 until n) {
        for (j in 0 until n) {
            print(table[i][j])
        }
        println()
    }
}

fun A() {
    scanner.apply {
        val t = nextInt()
        for (TEST in 0 until t) {
            val n = nextInt()
            val k = nextInt()
            printTable(n, k)
        }
    }
}
