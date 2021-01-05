import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.math.max
import kotlin.math.min

var enableDebug = false
private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

private var n: Int = 0

fun A() {
    scanner.apply {
        val T = nextInt()
        for (TEST in 1..T) {
            init()
            runTest(TEST, T)
        }
    }
}

fun init() {
}

fun runTest(test:Int, t: Int) {
    scanner.apply {
        n = nextInt()
        val array = IntArray(n)
        val maps = HashMap<Int, ArrayList<Pair<Int, HashMap<Int, Int>>>>()
        val mapArray = ArrayList<HashMap<Int, Int>>()
        for (i in 0 until n) {
            array[i] = nextInt()
            var num = array[i]
            val map = HashMap<Int, Int>()
            var cnt2 = 0
            while (num % 2 == 0) {
                cnt2++
                num /= 2
            }
            if (cnt2 != 0) {
                map[2] = cnt2
            }
            var mul = 3
            while (mul * mul <= num) {
                var cnt = 0
                while (num % mul == 0) {
                    cnt++
                    num /= mul
                }
                if (cnt != 0) {
                    map[mul] = cnt
                }

                mul += 2
            }

            if (num != 1) {
                map[num] = 1
            }

            for (k in map.keys) {
                if (!maps.containsKey(k)) {
                    maps[k] = ArrayList()
                }
                maps[k]!!.add(i to map)
            }
            mapArray.add(map)
        }
        val q = nextInt()
        for (i in 0 until q) {
            nextLong()
        }

        var maxAdj = 1
        val marked = BooleanArray(n)
        for (i in 0 until n) {
            if (marked[i]) {
                continue
            }
            var curAdj = 1
            val map = mapArray[i]
            for (k in map.keys) {
                val matching = maps[k]!!

                for ((j, matchingMap) in matching) {
                    if (j == i || marked[j]) continue

                    var isMatching = true
                    for (matchingKey in matchingMap.keys) {
                        if (!map.containsKey(matchingKey)) {
                            isMatching = false
                            break
                        }

                        val a = map[matchingKey]!!
                        val b = matchingMap[matchingKey]!!
                        val mx = max(a, b)
                        val mn = min(a, b)
                        if ((mx - mn) % 2 != 0) {
                            isMatching = false
                            break
                        }
                    }

                    for (nonMatchingKey in map.keys) {
                        if (matchingMap.containsKey(nonMatchingKey))
                            continue
                        else if (map[nonMatchingKey]!! % 2 != 0) {
                            isMatching = false
                            break
                        }
                    }

                    if (isMatching) {
                        curAdj++
                        marked[j] = true
                    }
                }
            }

            maxAdj = max(curAdj, maxAdj)

            marked[i] = true
        }

        for (i in 1..q) {
            println(maxAdj)
        }
    }
}

fun solve(heights: IntArray, k: Int) {
}
