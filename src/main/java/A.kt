import java.util.*
import kotlin.math.max
import kotlin.math.min

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

private var n: Int = 0
private val N = 1001
private val array = IntArray(N) { 1 }

fun A() {
    scanner.apply {
        preInit()
        val T = nextInt()
        nextLine()
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
        val (m, x) = nextInt() to nextLong()
        val c = LongArray(m)
        val h = IntArray(m)
        val canBeBought = BooleanArray(m)
        for (i in 0 until m) {
            c[i] = nextLong()
            h[i] = nextInt()
            canBeBought[i] = c[i] <= x * i
        }

        val maxHArr = LongArray(100_000)
        val possibleH = mutableSetOf(0)

        for (i in 0 until m) {
            val psh = mutableSetOf<Int>()
            for (hs in possibleH.sortedDescending()) {
                if (c[i] <= maxHArr[hs]) {
                    maxHArr[hs + h[i]] = max(maxHArr[hs + h[i]], maxHArr[hs] - c[i])
                    psh.add(hs + h[i])
                }
            }
            possibleH.addAll(psh)
            for (a in possibleH) {
                maxHArr[a] += x
            }
        }

        return possibleH.maxOrNull().toString()
    }
}
