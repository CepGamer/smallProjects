import java.util.*
import kotlin.math.max

private val scanner = Scanner(System.`in`)

fun res(success: Boolean) {
    if (success) {
        println("Yes")
    } else {
        println("No")
    }
}

fun exec(a: Long, b: Long, n: Long, m: Long) {
    if (a + b < n + m) {
        return res(false)
    }

    if (m <= a && m <= b) {
        return res(true)
    } else if (n >= listOf(a, b, m).max() ?: 0) {
        return res(true)
    } else {
        return res(false)
    }
}

fun B() {
    scanner.apply {
        val t = nextInt()
        for (TEST in 0 until t) {
            val a = nextLong()
            val b = nextLong()
            val n = nextLong()
            val m = nextLong()

            exec(a, b, n, m)
        }
    }
}
