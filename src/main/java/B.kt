import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

private val scanner = Scanner(System.`in`)

fun printResult(n: Int) {
    println(n)
}

fun B() {
    scanner.apply {
        val n = nextInt()
        val names = ArrayList<String>()
        val m = nextInt()
        for (i in 1..n) {
            names.add(next())
        }
        val beef = HashMap<String, ArrayList<String>>()
        for (name in names) {
            beef[name] = ArrayList()
        }
        for (i in 1..m) {
            val l = next()
            val r = next()
            beef[l]?.add(r)
            beef[r]?.add(l)
        }
        var max = 0
        var maxi = 0
        for (i in 1..(2 shl n - 1)) {
            val enabled = BitSet.valueOf(longArrayOf(i.toLong()))
            val res = names.foldIndexed(false) { index, x, s ->
                if (x || !enabled.get(index))
                    return@foldIndexed x
                names.forEachIndexed { i, name ->
                    if (enabled.get(i) && beef[s]?.contains(name) == true) {
                        return@foldIndexed true
                    }
                }

                false
            }
            if (res)
                continue

            if (enabled.cardinality() > max) {
                max = enabled.cardinality()
                maxi = i
            }
        }

        println(max)
        val enabled = BitSet.valueOf(longArrayOf(maxi.toLong()))
        val resNames = ArrayList<String>()
        names.forEachIndexed { i, s ->
            if (enabled.get(i)) {
                resNames.add(s)
            }
        }
        resNames.sort()
        for (name in resNames) {
            println(name)
        }
    }
}
