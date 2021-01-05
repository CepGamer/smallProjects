import java.util.*

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

private var n: Int = 0

var debug = false

fun B() {
    scanner.apply {
        val T = nextInt()

        for (TEST in 1..T) {
            initB()
            runTestB(T, TEST)
        }
    }
}

fun initB() {
}

fun runTestB(T: Int, t: Int) {
    scanner.apply {
        n = nextInt()
        val x = nextInt()
        var sum = 0L
        val array = IntArray(n)

        var i = 0
        var stopped = false
        var multiple = 1
        for (j in 0 until n) {
            val num = nextInt()
            array[j] = num
        }

        while (true) {
            for (j in 0 until n) {
                val num = array[j]
                sum += num * multiple
                i = j
                if (!stopped && num % x == 0) {
                    array[j] = num / x
                } else {
                    stopped = true
                    break
                }
            }

            if (stopped) {
                for (j in (i + 1) until n) {
                    sum += array[j] * multiple
                }
                multiple *= x
                for (j in 0 until i) {
                    sum += array[j] * multiple
                }
                println(sum)
                return
            }
            multiple *= x
        }
    }
}

fun solveB(str: String, k: Int) {
}
