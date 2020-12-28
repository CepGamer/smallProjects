import java.util.*
import kotlin.math.max
import kotlin.math.roundToInt
import kotlin.math.sqrt

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

private var n: Int = 0

fun C() {
    scanner.apply {
        val T = nextInt()

        for (TEST in 1..T) {
            initC()
            runTestC()
        }
    }
}

fun initC() {
}

fun runTestC() {
    scanner.apply {
        n = nextInt()
        solveC()
        println()
    }
}

fun solveC() {
    if (n == 3) {
        print("2 3 2 3 2 ")
        return
    }

    val sqrtChain = ArrayList<Int>()
    sqrtChain.add(n)

    val sqrtSteps = ArrayList<ArrayList<Int>>()

    while (true) {
        val l = sqrtChain.last()
        var sqrt = sqrt(l.toDouble()).roundToInt()

        if (sqrt * sqrt < l) {
            sqrt++
        }
        sqrtChain.add(sqrt)

        val steps = ArrayList<Int>()
        while (true) {
            steps.add(l)
            steps.add(sqrt)
            if ((l / sqrt) == 0) {
                break
            }
            steps.add(l)
            steps.add(sqrt)

            break
        }
        sqrtSteps.add(steps)

        if (sqrt <= 2) {
            break
        }
    }

    print("${n + sqrtSteps.fold(0) { acc, arr -> acc + arr.size / 2 } - sqrtChain.size - 1} ")
    for (i in 0 until (sqrtChain.size - 1)) {
        val r = sqrtChain[i]
        val l = sqrtChain[i + 1]
        for (j in l until (r - 1)) {
            print("${j + 1} ${j + 2} ")
        }
        for (step in sqrtSteps[i]) {
            print("$step ")
        }
    }
}
