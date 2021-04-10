import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.HashMap
import kotlin.collections.HashSet
import kotlin.math.max

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

private val count = HashMap<Int, Int>()
private lateinit var arr: IntArray

private var n: Int = 0

fun C() {
    scanner.apply {
        val T = nextInt()
        for (TEST in 1..T) {
            initC()
            println(runTestC())
        }
    }
}

fun initC() {
    count.clear()
}

fun runTestC(): String {
    scanner.apply {
        var (a, b) = nextInt() to nextInt()
        nextLine()
        val s = nextLine()
        n = s.length

        val chars = s.toCharArray()

        if (s == "?") {
            return if (a > 0) "0"
            else if (b > 0) "1"
            else "-1"
        }

        for (i in 0 until (n / 2 + n % 2)) {
            if (chars[i] == '?' && chars[n - i - 1] != '?') {
                chars[i] = chars[n - i - 1]
            } else if (chars[n - i - 1] == '?' && chars[i] != '?') {
                chars[n - i - 1] = chars[i]
            } else if (chars[i] != chars[n - i - 1]) {
                return "-1"
            }
            val x = if (i == n / 2 && n % 2 == 1) 1 else 2
            if (chars[i] == '0') a -= x else if (chars[i] == '1') b -= x
        }

        for (i in 0 until (n / 2 + n % 2)) {
            if (chars[i] == '?') {
                val x = if (i == n / 2 && n % 2 == 1) 1 else 2
                val c = if (a > b) {
                    a -= x
                    '0'
                } else {
                    b -= x
                    '1'
                }
                chars[i] = c
                chars[n - i - 1] = c
            }
        }

        return if (a == 0 && b == 0) chars.joinToString("") else "-1"
    }
}

fun solveC(str: String) {
}
