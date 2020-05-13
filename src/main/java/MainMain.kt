import java.util.*

val scanner = Scanner(System.`in`)

fun main() {
    scanner.apply {
        val n = nextInt()

        for (i in 1..n) {
            val s = nextInt().toString()
            println(s.length - s.count { c -> c == '0' })
            s.forEachIndexed { index, c ->
                if (c != '0')
                    print("$c${"0".repeat(s.length - index - 1)} ")
            }
            println()
        }
    }
}
