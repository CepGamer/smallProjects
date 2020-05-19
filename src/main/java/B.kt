import java.lang.StringBuilder
import java.util.*
import kotlin.math.min

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

fun main() {
    scanner.apply {
        val arr = IntArray(size)
        var dp = 1L
        val n = nextInt()
        var res = 0L
        for (i in 0 until n) {
            arr[i] = nextInt()
            var dpi = 1L
            if (i > 0 &&
                arr[i] == arr[i - 1]) {
                dpi = dp + 1L
            }
            dp = dpi
            res += dp
        }

        println(res)
    }
}
