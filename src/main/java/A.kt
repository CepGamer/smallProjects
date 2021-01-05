import java.lang.StringBuilder
import java.util.*
import kotlin.math.max

var enableDebug = false
private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

private var n: Int = 0
private val N = 1_000_000 + 10
private val array = IntArray(N)
private val count = IntArray(N)
private val isEqual0 = BooleanArray(N)

fun A() {
    scanner.apply {
        preInit()
        val T = nextInt()
        for (TEST in 1..T) {
            init()
            runTest(TEST, T)
        }
    }
}

fun preInit() {
    for (i in 1..1000_000) {
        if (array[i] != 0) {
            continue
        }
        var j = 1
        while (i * j * j < N) {
            array[i * j * j++] = i
        }
    }
}

fun init() {
}

fun runTest(test:Int, t: Int) {
    scanner.apply {
        n = nextInt()

        var maxSize = 0
        var even = 0
        val arr = IntArray(n)

        for (i in 0 until n) {
            val num = nextInt()
            arr[i] = num
            val squareRemainder = array[num]
            maxSize = max(maxSize, ++count[squareRemainder])
        }

        val one = count[1]
        for (num in arr) {
            val squareRemainder = array[num]
            if (count[squareRemainder] and 1 == 0 && squareRemainder != 1) {
                even += count[squareRemainder]
            }
            count[squareRemainder] = 0
        }

        val q = nextInt()
        val string = StringBuilder()
        val a = maxSize
        val b = max(maxSize, even + one)

        for (i in 0 until q) {
            string.append(if (nextLong() == 0L) a else b).append('\n')
        }

        print(string)

        count[1] = 0
    }
}

fun solve(heights: IntArray, k: Int) {
}
