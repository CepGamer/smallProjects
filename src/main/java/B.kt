import java.util.*
import kotlin.math.max
import kotlin.math.min

private val scanner = Scanner(System.`in`)

fun B() {
    scanner.apply {
        val t = nextInt()
        for (TEST in 0 until t) {
            val n = nextLong()
            val r = nextLong()

            val min = min(n - 1, r)
            val surplus = if (r >= n) 1 else 0
            println(min * (min + 1) / 2 + surplus)
        }
    }
}
