import java.io.BufferedInputStream
import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.HashMap
import kotlin.math.max
import kotlin.math.min

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

private var n: Int = 0

private lateinit var Int: BooleanArray
private lateinit var edges: Array<ArrayDeque<Int>>

private lateinit var divisors: Array<ArrayDeque<Int>>
private lateinit var divisorByInt: List<Pair<Int, ArrayDeque<Int>>>

private lateinit var dynamic: BooleanArray

fun D() {
    scanner.apply {
        val T = nextInt()
        nextLine()

        for (TEST in 1..T) {
            println(runTestD(T, TEST))
        }
    }
}

private fun runTestD(T: Int, t: Int): String {
    scanner.apply {
        val n = nextInt()
        nextLine()
        val s = nextLine()

        val rover = BooleanArray(n)
        var wasHeli = false
        var (dx, dy) = 0 to 0

        for (i in s.indices) {
            when (s[i]) {
                'N' -> if (dx >= 0) {
                    if (dx == 0 && !wasHeli) {
                        wasHeli = true
                        dx++
                    } else {
                        rover[i] = true
                        dx--
                    }
                } else {
                    wasHeli = true
                    dx++
                }

                'S' -> if (dx <= 0) {
                    if (dx == 0 && !wasHeli) {
                        wasHeli = true
                        dx--
                    } else {
                        rover[i] = true
                        dx++
                    }
                } else {
                    dx--
                    wasHeli = true
                }

                'E' -> if (dy >= 0) {
                    if (dy == 0 && !wasHeli) {
                        wasHeli = true
                        dy++
                    } else {
                        rover[i] = true
                        dy--
                    }
                } else {
                    wasHeli = true
                    dy++
                }

                'W' -> if (dy <= 0) {
                    if (dy == 0 && !wasHeli) {
                        wasHeli = true
                        dy--
                    } else {
                        rover[i] = true
                        dy++
                    }
                } else {
                    wasHeli = true
                    dy--
                }
            }
        }

        return if (dx == 0 && dy == 0 && rover.any { it } && rover.any { !it }) rover.map { if (it) 'R' else 'H' }
            .joinToString("") else "NO"
    }
}

class FastScannerD {
    private val BS = 1 shl 16
    private val NC = 0.toChar()
    private val buf = ByteArray(BS)
    private var bId = 0
    private var size = 0
    private var c = NC
    private var `in`: BufferedInputStream? = null

    private val char: Char
        get() {
            while (bId == size) {
                size = try {
                    `in`!!.read(buf)
                } catch (e: Exception) {
                    return NC
                }
                if (size == -1) return NC
                bId = 0
            }
            return buf[bId++].toChar()
        }

    fun nextInt(): Int {
        var neg = false
        if (c == NC) c = char
        while (c < '0' || c > '9') {
            if (c == '-') neg = true
            c = char
        }
        var res = 0
        while (c >= '0' && c <= '9') {
            res = (res shl 3) + (res shl 1) + (c - '0')
            c = char
        }
        return if (neg) -res else res
    }

    init {
        `in` = BufferedInputStream(System.`in`, BS)
    }
}
