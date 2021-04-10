import java.util.*

var enableDebug = false
private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

private var n: Int = 0
private val N = 5_000 + 1
private val array = IntArray(N)
private val count = IntArray(N)
private val isEqual0 = BooleanArray(N)

val modulo = 1000_000_000L + 7L

val paths = Array(N) { LongArray(N) }
val times = LongArray(N)

fun A() {
    scanner.apply {
        preInit()
        val T = nextInt()
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
        val n = nextInt()
        val a = nextInt()
        val b = nextInt()
        val c = nextInt()

        var res = -1
        val same = if (a == b || a == c) a else b
        if (a != same) res = 1 else if (b != same) res = 2 else if (c != same) res = 3

        for (i in 1..(n - 3)) {
            val x = nextInt()
            if (x != same) res = i + 3
        }

        return res.toString()
    }
}

fun solve(heights: IntArray, k: Int) {
}
