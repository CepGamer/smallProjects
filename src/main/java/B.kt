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
        val modulo = 1_000_000_000L + 7L
        val bitsCount = LongArray(63)
        val vals = LongArray(n)
        for (i in 0 until n) {
            val x = nextLong()
            vals[i] = x
            for (j in 0..62) {
                bitsCount[j] += if (x and (1L shl j) != 0L) 1L else 0L
            }
        }

        var res = 0L
        for (i in 0 until n) {
            var sumOr = 0L
            var sumAnd = 0L
            val x = vals[i]
            for (j in 0..62) {
                if (x and (1L shl j) != 0L) {
                    sumAnd += ((1L shl j) * bitsCount[j])
                    sumOr += ((1L shl j) * n)
                } else {
                    sumOr += ((1L shl j) * bitsCount[j])
                }
            }
            res = (res + (sumAnd % modulo) * (sumOr % modulo)) % modulo
        }

        println(res)
    }
}

fun solveB(str: String, k: Int) {
}
