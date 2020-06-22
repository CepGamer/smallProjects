import java.util.*

private val scanner = Scanner(System.`in`)
private val size = 100_000 + 10

fun IntArray.binarySearch(value: Int, from: Int, to: Int, valExtractor: (Int) -> Int): Int {
    var l = from
    var r = to
    var m = (l + r) / 2
    do {
        if (value > valExtractor(m)) {
            l = m
        } else
            r = m
        m = (l + r) / 2
    } while (l < r - 1)

    return l
}

fun A() {
    scanner.apply {
        val n = nextInt()
        val arr = IntArray(size)
        for (i in 0 until n) {
            arr[i] = nextInt()
        }
        val brr = IntArray(size, init = { i -> 1000_000_000 + 10 })

        brr[n - 1] = n - 1
        for (i in (n - 2) downTo 0) {
            brr[i] =
                if (arr[i] < arr[brr[i + 1]]) {
                    i
                } else {
                    brr[i + 1]
                }
        }
        for (i in 0 until n) {
            val nextYoung = brr.binarySearch(arr[i], i, n) { i -> arr[brr[i]] }
            print("${nextYoung - i - 1} ")
        }
    }
}
