import java.util.*
import kotlin.math.max

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

fun gcd(a: Int, b: Int): Int =
    if (b > 0)
        gcd(b, a % b)
    else
        a

fun A() {
    scanner.apply {
        val A = nextInt()
        var sum = 0
        for (base in 2 until A) {
            var cursum = 0
            var cura = A
            while (cura > 0) {
                cursum += cura % base
                cura /= base
            }
            sum += cursum
        }
        val gcd = gcd(sum, A - 2)
        println("${sum/gcd}/${(A-2)/gcd}")
    }
}
