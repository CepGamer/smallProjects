import java.util.*
import kotlin.math.max

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

fun A() {
    scanner.apply {
        val t = nextInt()
        for (TEST in 1..t) {
            val arr = IntArray(size)
            val f = IntArray(size)
            val n = nextInt()
            for (i in 1..n) {
                arr[i] = nextInt()
                f[i] = 1
            }
            for (i in 1..n) {
                var j = i * 2
                while (j <= n) {
                    if (arr[i] < arr[j]) {
                        f[j] = max(f[j], f[i] + 1)
                    }
                    j += i
                }
            }
            println(f.max())
        }
    }
}
