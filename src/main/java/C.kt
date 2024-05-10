import java.util.*
import kotlin.math.max
import kotlin.math.min

private val scanner = Scanner(System.`in`)

private lateinit var arr: IntArray

fun C() {
    scanner.apply {
        val T = nextInt()
        nextLine()
        for (TEST in 1..T) {
            println(runTestC())
        }
    }
}

fun runTestC(): String {
    scanner.apply {
        val (t1, t2) = nextInt() to nextInt()
        val (t3, t4) = nextInt() to nextInt()
        val (a, b) = min(t1, t2) to max(t1, t2)
        val (c, d) = min(t3, t4) to max(t3, t4)

        val x1 = c in a..b
        val x2 = d in a..b

        return if (x1 xor x2) "YES" else "NO"
    }
}
