import java.util.*

val scanner = Scanner(System.`in`)

fun main() {
    scanner.apply {
        val t = nextInt()

        for (i in 1..t) {
            val n = nextInt()
            if (n % 4 != 0) {
                println("NO")
            } else {
                println("YES")
                for (j in 1..(n / 2)) {
                    print("${j * 2} ")
                }
                for (k in 1 until n / 2) {
                    print("${k * 2 - 1} ")
                }
                println("${n + n / 2 - 1}")
            }
        }
    }
}
