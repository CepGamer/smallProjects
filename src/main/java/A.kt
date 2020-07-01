import com.sun.org.apache.xpath.internal.operations.Bool
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max
import kotlin.math.min

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
