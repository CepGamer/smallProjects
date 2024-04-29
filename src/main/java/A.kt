import java.util.*
import kotlin.math.max
import kotlin.math.min

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

private var n: Int = 0
private val N = 50 + 1
private val array = IntArray(N)

fun A() {
    scanner.apply {
        preInit()
        val T = nextInt()
        nextLine()
        for (TEST in 1..T) {
            println(runTest(TEST, T))
        }
    }
}

fun preInit() {
}

fun init(k: Int) {
}

fun runTest(test: Int, t: Int): String {
    scanner.apply {
        n = nextInt()
        for (i in 1..n) {
            array[i] = nextInt()
        }

        for (i in 1..n) {
            if (i == array[array[i]]) {
                return "2"
            }
        }
        return "3"
    }
}

fun solve(heights: IntArray, k: Int) {
}
