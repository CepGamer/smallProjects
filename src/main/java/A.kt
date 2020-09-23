import java.util.*

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

fun A() {
    scanner.apply {
        val t = nextInt()
        for (TEST in 0 until t) {
            val n = nextInt()
            println((n + 1) / 2)
        }
    }
}
