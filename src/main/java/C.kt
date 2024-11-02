import java.util.*
import kotlin.collections.HashMap
import kotlin.math.max
import kotlin.math.min

private val scanner = Scanner(System.`in`)

private lateinit var arr: IntArray

fun C() {
    scanner.apply {
        val T = nextInt()
        nextLine()
        for (TEST in 1..T) {
            println(runTestC())
        }
    }
}

fun runTestC(): String {
    scanner.apply {
        val s = StringBuilder(nextLine())
        val n = s.length
        val q = nextInt()

        val current = HashSet<Int>()
        for (i in 0 until n - 3) {
            if (s.substring(i..i + 3) == "1100") {
                current += i
            }
        }

        val res = StringBuilder()
        for (i in 0 until q) {
            val (j, v) = nextInt() - 1 to nextInt().toString()[0]
            if (s[j] != v) {
                s[j] = v
                if (v == '1') {
                    current.remove(j - 1)
                    current.remove(j - 2)
                    current.remove(j - 3)
                    for (k in -1..1) {
                        val p = j + k
                        if (p < 0 || (p + 3) >= n) continue
                        if (s.substring(p..p + 3) == "1100") {
                            current += p
                            break
                        }
                    }
                } else {
                    current.remove(j)
                    current.remove(j - 1)
                    current.remove(j + 1)
                    for (k in -3..-1) {
                        val p = j + k
                        if (p < 0 || (p + 3) >= n) continue
                        if (s.substring(p..p + 3) == "1100") {
                            current += p
                            break
                        }
                    }
                }
            }
            res.append(if (current.isNotEmpty()) {
                 "YES"
            } else "NO")
            res.append("\n")
        }
        nextLine()

        return res.toString()
    }
}

private fun lcm(a: Int): IntArray {
    val res = IntArray(21)
    var x = a

    for (i in 2..20) {
        while (x % i == 0) {
            res[i]++
            x /= i
        }
    }

    return res
}

private infix fun <T> MutableMap<T, Int>.addOne(p: T) {
    if (p in this) {
        this[p] = this[p]!! + 1
    } else {
        this[p] = 1
    }
}

private infix fun <T> MutableMap<T, Int>.remOne(p: T) {
    if (p in this) {
        this[p] = this[p]!! - 1
    } else {
        this[p] = -1
    }
}
