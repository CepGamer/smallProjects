import java.util.*
import kotlin.math.abs

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

private var n: Int = 0

fun C() {
    scanner.apply {
        val T = 1//nextInt()
        for (TEST in 1..T) {
            initC()
            println(runTestC())
        }
    }
}

fun initC() {
}

fun runTestC(): String {
    scanner.apply {
        var n1 = nextInt()
        var n2 = nextInt()
        var n3 = nextInt()

        var bag1 = LongArray(n1)
        var bag2 = LongArray(n2)
        var bag3 = LongArray(n3)

        for (i in 0 until n1) {
            bag1[i] = nextLong()
        }
        for (i in 0 until n2) {
            bag2[i] = nextLong()
        }
        for (i in 0 until n3) {
            bag3[i] = nextLong()
        }

        bag1.sort()
        bag2.sort()
        bag3.sort()

        var someArray: List<Long> = arrayListOf(bag1[0], bag2[0], bag3[0],
            bag1.takeLast(n1 - 1).sum(), bag2.takeLast(n2 - 1).sum(), bag3.takeLast(n3 - 1).sum()).sorted()

        someArray = someArray.filter { it != 0L }

        if (someArray.size == 3)
            return (someArray[2] + (someArray[1] - someArray[0])).toString()

        return (someArray.takeLast(someArray.size - 3).sum() + someArray[2] - someArray[0] - someArray[1]).toString()
    }
}

fun solveC(str: String) {
}
