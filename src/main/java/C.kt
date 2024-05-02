import java.util.*

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
        val n = nextInt() - 1
        val xr = LongArray(n) { nextLong() }
        val ar = LongArray(n + 1)

        ar[0] = 501
        for (i in 0 until n) {
            ar[i + 1] = ar[i] + xr[i]
        }

        return ar.joinToString(" ")
    }
}
