import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

private val scanner = Scanner(System.`in`)

fun main() {
    println(divide(Int.MIN_VALUE, -1))
    println(divide(Int.MIN_VALUE, 2))

    println(1073741823 * 10)

    println(longestPalindrome("abb"))

    println(isMatch("aab", "c*a*b"))
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
            val transitions: HashMap<Char, ArrayList<State>> = HashMap<Char, ArrayList<State>>()) {
}

fun isMatch(s: String, p: String): Boolean {
    val state = buildStates(p)
    var activeStates = HashSet<State>()
    activeStates.add(state)
    for (c in s) {
        val newActive = HashSet<State>()
        for (state in activeStates) {
            if (state.transitions.containsKey(c))
                newActive.addAll(state.transitions[c]!!)
        }
        if (newActive.size == 0) {
            return false
        }
        activeStates = newActive
    }

    return activeStates.any{ it.isFinal }
}

fun buildStates(pattern: String): State {
    val res = State(false)
    var curState: State = res
    var prev = pattern[0]
    var i = 0
    while (i < pattern.length) {
        var c = pattern[i]
        when (c) {
            '*' -> {
                if (prev == '.') {
                    ('a'..'z').forEach { curState.transitions[it] = arrayListOf(curState) }
                } else {
                    curState.transitions[prev] = arrayListOf(curState)
                }
                i++
                c = pattern[i]
            }
            else -> {
                val newState = State(false)
                when (c) {
                    '.' -> {
                        ('a'..'z').forEach {
                            if (curState.transitions[it] != null)
                                curState.transitions[it]!!.add(newState)
                            else curState.transitions[it] = arrayListOf(newState)
                        }
                    }
                    else -> if (curState.transitions[c] != null)
                        curState.transitions[c]!!.add(newState)
                    else curState.transitions[c] = arrayListOf(newState)
                }
                curState = newState
            }
        }
        i++
        prev = c
    }
    curState.isFinal = true
    return res
}
