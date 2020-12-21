import java.util.*

var enableDebug = false
private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

private var n: Int = 0

fun A() {
    scanner.apply {
        val T = 1//nextInt()
        for (TEST in 1..T) {
            init()
            runTest()
        }
    }
}

fun init() {
}

fun runTest() {
    scanner.apply {
        val s = nextLine()
        val x = nextInt()
        val y = nextInt()
        println(solve(s, x, y))
    }
}

fun solve(line: String, x: Int, y: Int): Long {
    var os = 0L
    var ones = 0L

    val string: String
    val w1: Long
    val w2: Long

    if (x > y) {
        string = line.replace('0', 'a').replace('1', '0').replace('a', '1')
        w1 = y.toLong()
        w2 = x.toLong()
    } else {
        string = line
        w1 = x.toLong()
        w2 = y.toLong()
    }

    val total0s = string.count { c -> c == '0' }.toLong()
    val totalQuestions = string.count { c -> c == '?' }.toLong()
    val total1s = string.count { c -> c == '1' }.toLong() + totalQuestions

    // count sum
    var sum = 0L
    for (element in string) {
        when (element) {
            '1' -> {
                ones++
                sum += w1 * os
            }
            '0' -> {
                os++
                sum += w2 * ones
            }
            '?' -> {
                ones++
                sum += w1 * os
            }
        }
    }

    var minRes = sum
    ones = 0L
    os = 0L
    var qs = 0L
    for (c in string) {
        when (c) {
            '1' -> ones++
            '0' -> os++
            '?' -> {
                sum -= w1 * (os + qs) + w2 * (total0s - os)
                sum += w1 * (total1s - ones - 1L - qs) + w2 * ones
                qs++

                minRes = minOf(minRes, sum)
            }
        }
    }

    return minRes
}
