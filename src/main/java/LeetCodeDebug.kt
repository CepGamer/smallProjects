import java.io.File
import java.util.*
import kotlin.collections.HashMap

class LeetCodeDebug {
    lateinit var s: String
    var i = 0

    val stack = mutableListOf<Int>()
    val opStack = mutableListOf<Char>()

    fun calculate(s: String): Int {
        this.s = s
        return process()
    }

    private fun process(): Int {
        var start = true
        while (i < s.length) {
            while (i < s.length && s[i] == ' ') i++
            if (i >= s.length) break
            when (s[i]) {
                '-', '+', '(' -> {
                    if (start && s[i] == '-') opStack.add('u')
                    else {
                        start = s[i] == '('
                        opStack.add(s[i])
                    }
                    i++
                }
                ')' -> {
                    start = false
                    opStack.removeLast()
                    i++
                    processOps()
                }
                else -> {
                    start = false
                    stack.add(getNumber())
                    processOps()
                }
            }
        }

        return stack.removeLast()
    }
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val winSize = 30
        val window = Array(winSize) { mutableSetOf<Int>() }
        val hash = words.groupBy { it }.mapValues { (_, v)  -> v.size }
        val res = mutableListOf<Int>()
        val offset = words[0].length * words.size

        for (i in 0 until s.length) {
            if (i + offset >= s.length) break

            val set = hash.toMutableMap()
            for (j in 1..words.size) {
                val sub = s.substring(i + (j - 1) * words[0].length, i + j * words[0].length)
                if (sub in set) {
                    if (set[sub] == 1) {
                        set.remove(sub)
                    } else {
                        set[sub]
                    }
                } else {
                    break
                }
            }

            if (set.isEmpty()) res.add(i)
        }

        return res
    }

    private fun processOps() {
        while (opStack.isNotEmpty()) {
            val op = opStack.removeLast()
            when(op) {
                '+' -> {
                    stack.add(stack.removeLast() + stack.removeLast())
                }
                '-' -> stack.add(-stack.removeLast() + stack.removeLast())
                '(' -> {
                    opStack.add('(')
                    return
                }
            }
        }
    }

    private fun getNumber(): Int {
        var x = 0
        while (i < s.length && s[i] in '0'..'9') {
            x *= 10
            x += s[i] - '0'
            i++
        }

        return x
    }
}

fun main() {
    val sln = { LeetCodeDebug() }
    println(sln().calculate("(1+(4+5+2)-3)+(6+8)"))
}

private fun parse() {
    val f = File("C:\\Users\\sbolo\\Documents\\smallProjects\\src\\main\\java\\resource.txt").readLines()
//    asrt(sln().equalSubstring("thjdoffka", "qhrnlntls", 11), 3)
    val arr = Regex("""\[(\d+),\s?(\d+)]""")
        .findAll(f[0])
        .map { res ->
            res.destructured.toList()
                .map {
                    it.toInt()
                }
                .take(2)
                .toIntArray()
        }
        .toList().toTypedArray()
}

fun asrt(b: Boolean) {
    if (!b) throw java.lang.AssertionError("Failed")
}

fun <T> asrt(a: T, b: T) {
    if (a != b) throw AssertionError("Failed: $a got, $b expected")
}
