import java.util.*

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

fun A() {
    println(Solution().decodeString("3[a]2[bc]"))
    println(Solution().decodeString("3[a2[c]]"))
    println(Solution().decodeString("2[abc]3[cd]ef"))
}

class Solution {
    private lateinit var str: String
    private var index = 0

    fun decodeString(s: String): String {
        str = s
        val res = StringBuilder()
        while (index < str.length) {
            val node = decode()
            res.append(node)
        }

        return res.toString()
    }

    private fun decode(): String {
        val node = when {
            Character.isLetter(str[index]) -> parseString()
            Character.isDigit(str[index]) -> decodeLoop()
            else -> ""
        }

        return node
    }

    private fun decodeLoop(): String {
        var count = 0
        while (Character.isDigit(str[index])) {
            count = count * 10 + str[index++].toInt() - '0'.toInt()
        }
        // skip '['
        index++
        val repeated = StringBuilder()
        while (str[index] != ']') {
            val next = decode()
            repeated.append(next)
        }
        // skip ']'
        index++
        return repeated.toString().repeat(count)
    }

    private fun parseString(): String {
        val builder = StringBuilder()
        while (index < str.length && Character.isLetter(str[index])) {
            builder.append(str[index++])
        }

        return builder.toString()
    }
}
