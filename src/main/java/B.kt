import java.io.File
import java.util.*


private val scanner = Scanner(System.`in`)

fun B() {
    val res = solve()
    val out = File("output.txt")
    out.createNewFile()
    out.writeText(if (res) "YES" else "NO")
}

fun solve(): Boolean {
    val file = File("input.txt")
    val sc = Scanner(file)

    sc.apply {
        val n = nextInt()
        nextLine()
        val s = nextLine()
        var hasBegun = false
        var cycleInitiated = false
        var cyclePeriod = 0
        var curCycle = 0
        var hasEnded = false
        for (c in s) {
            if (!hasBegun) {
                hasBegun = c == '1'
                continue
            }
            else if (!cycleInitiated) {
                if (c == '1') {
                    cycleInitiated = true
                    curCycle = cyclePeriod
                } else {
                    cyclePeriod++
                }
            } else if (!hasEnded) {
                if (c == '1') {
                    if (curCycle == 0) {
                        curCycle = cyclePeriod
                    } else {
                        return false
                    }
                } else if (curCycle == 0) {
                    hasEnded = true
                } else {
                    curCycle--
                }
            } else if (hasEnded && c == '1') {
                return false
            }
        }

        return true
    }
}
