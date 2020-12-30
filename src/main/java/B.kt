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
        val bitsCount = LongArray(60)
        val pow = LongArray(60) { 1 }
        for (i in 1..59) {
            pow[i] = pow[i - 1] * 2L % modulo
        }
        val vals = LongArray(n)
        for (i in 0 until n) {
            val x = nextLong()
            vals[i] = x
            for (j in 0..59) {
                bitsCount[j] += if (x and (1L shl j) != 0L) 1L else 0L
            }
        }

        var res = 0L
        for (i in 0 until n) {
            var sumOr = 0L
            var sumAnd = 0L
            val x = vals[i]
            for (j in 0..59) {
                if (x and (1L shl j) != 0L) {
                    sumAnd = (sumAnd + (pow[j]) * bitsCount[j]) % modulo
                    sumOr = (sumOr + (pow[j]) * n) % modulo
                } else {
                    sumOr = (sumOr + (pow[j]) * bitsCount[j]) % modulo
                }
            }
            res = (res + (sumAnd * sumOr)) % modulo
        }

        println(res)
    }
}

fun solveB(str: String, k: Int) {
}
