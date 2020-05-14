import java.util.*
import kotlin.math.max

private val scanner = Scanner(System.`in`)

fun A() {
    scanner.apply {
        val arr = IntArray(40)
        val brr = IntArray(40)
        val t = nextInt()
        for (i in 1..t) {
            for (j in 0 until 40) {
                arr[j] = 0
                brr[j] = 0
            }
            val n = nextInt()
            val k = nextInt()
            for (j in 0 until n) {
                arr[j] = nextInt()
            }
            for (j in 0 until n) {
                brr[j] = nextInt()
            }
            arr.sortDescending()
            brr.sortDescending()
            for (j in 0 until k) {
                arr[n - j - 1] = max(brr[j], arr[n - j - 1])
            }
            println(arr.sum())
        }
    }
}
