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
    var os = 0
    var ones = 0
    var questions = 0

    val maximize01s = x < y

    val total0s = line.count {c -> c == '0'}
    val total1s = line.count {c -> c == '1'}
    val totalQuestions = line.count {c -> c == '?'}

    var minRes = x.toLong() * line.length + y.toLong() * line.length

    for (i in 0 until line.length) {
        val c = line[i]
        when (c) {
            '1' -> ones++
            '0' -> os++
            '?' -> questions++
        }
        minRes = arrayOf(
            
        ).min()
    }

    return minRes
}
