import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

private val scanner = Scanner(System.`in`)

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
fun main() {
    println(divide(Int.MIN_VALUE, -1))
    println(divide(Int.MIN_VALUE, 2))

    println((-1).toUInt())

    println(!isMatch("mississippi", "mis*is*p*."))
    println(isMatch("aab", "c*a*b"))
    println(!isMatch("aaba", "ab*a*c*a"))

    var node = TreeNode(5) as TreeNode?
    while (node != null) {
        node?.let {
            it
        }
        node = node?.left

        println(node)
    }
}

fun divide(dividend: Int, divisor: Int): Int {
    var div = if (dividend < 0 && dividend != Int.MIN_VALUE) -dividend else dividend
    var divs = if (divisor < 0) -divisor else divisor
    val isNegative = (divisor < 0 && dividend > 0) || (dividend < 0 && divisor > 0)

    if (div < divs && div != Int.MIN_VALUE) {
        return 0
    }

    if (divisor == 1) {
        return dividend
    }

    var times = 1
    var quotient = 0
    while ((divs <= div || div == Int.MIN_VALUE) && times != 0 && divs and 0xB0000000.toInt() == 0) {
        divs = divs shl 1
        times = times shl 1
    }

    if (divs > div && div != Int.MIN_VALUE) {
        divs = divs shr 1
        times = times shr 1
    } else if (div == Int.MIN_VALUE) {
        divs = divs shl 1
        times = times shl 1
    }

    while (times > 0) {
        if (div >= divs) {
            div -= divs
            quotient += times
        } else if (div < 0 && div <= -divs) {
            // only case for Int.MIN_VALUE
            div += divs
            quotient += times
        }

        divs = divs shr 1
        times = times shr 1
    }

    return if (isNegative) -quotient else quotient
}


class State(var isFinal: Boolean,
            var emptyTransitions: ArrayList<State> = arrayListOf(),
            val transitions: HashMap<Char, ArrayList<State>> = HashMap<Char, ArrayList<State>>()) {
}

fun isMatch(s: String, p: String): Boolean {
    return false
}


fun convert(s: String, numRows: Int): String {
    if (numRows == 1) {
        return s
    }
    val cycle = (numRows - 1) * 2
    val stringBuilders = Array(numRows) { StringBuilder() }
    s.forEachIndexed { i, c ->
        if (i % cycle == 0) {
            stringBuilders[0].append(c)
        } else if ((i + cycle / 2) % cycle == 0) {
            stringBuilders[numRows - 1].append(c)
        } else {
            val j = i % cycle
            if (j < numRows) {
                stringBuilders[j].append(c)
            } else {
                stringBuilders[cycle - j].append(c)
            }
        }
    }

    val builder = StringBuilder(s.length)

    stringBuilders.forEach { builder.append(it.toString()) }

    return builder.toString()
}
