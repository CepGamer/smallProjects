import java.util.*
import kotlin.math.abs

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

fun runTestB(T:Int, t: Int) {
    scanner.apply {
        n = nextInt()
        val k = nextInt()
        nextLine()
        val s = nextLine()
        debug = debug// || T == 1 && n == 1000000 && k == 1000000
        if (!debug)
            println(solveB(s, k))
        else if (debug)
            println("${s.indexOf('0')}")
    }
}

fun solveB(str: String, k: Int): String {
    val digiValues = str.map { c -> c - '0' }.toIntArray()
    var cur = 0
    val start = 0
    var last0 = -1000000
    for (i in 0 until k.coerceAtMost(20)) {
        cur += (1 - digiValues[start + k.coerceAtMost(20) - 1 - i]) shl i
        last0 = if (str[i] == '0') i else last0
    }
    val set = mutableSetOf<Int>()
    if (k <= 20) {
        set.add(cur)
    }
    for (i in k.coerceAtMost(20) until str.length) {
        cur = (1 - digiValues[i] + (cur shl 1)) and ((1 shl k.coerceAtMost(20)) - 1)
        last0 = if (str[i] == '0') i else last0
        if (i >= (k - 1) && !(cur == 0 && abs(i + 1 - last0) <= k)) {
            set.add(cur)
        }
    }
    for (i in 0 until (1 shl k.coerceAtMost(20))) {
        if (i !in set) {
            return "YES\n" + "0".repeat((k - 20).coerceAtLeast(0)) +
                    (i + (1 shl k.coerceAtMost(20))).toString(2).substring(1)
        }
    }

    return "NO"
}
