import java.util.*

val scanner = Scanner(System.`in`)

fun main() {
    scanner.apply {
        val n = nextInt()

        for (i in 1..n) {
            val c = nextInt()
            val half = c / 2
            var s = 0
            for (j in 1..half)
                s += 1 shl j
            println(s)
        }
    }
}
