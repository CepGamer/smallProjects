import java.util.*

var enableDebug = false
private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

private var n: Int = 0

fun A() {
    scanner.apply {
        val T = nextInt()
        nextLine()
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
        println(if (solve(s)) "YES" else "NO")
    }
}

fun solve(line: String): Boolean {
    val posOp = line.indexOf('(')
    val posCl = line.indexOf(')')

    return (line.length % 2 == 0
            && posCl > 0 && posOp < (line.length - 1))
}
