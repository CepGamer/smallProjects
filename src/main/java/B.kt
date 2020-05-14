import java.util.*

private val scanner = Scanner(System.`in`)
private val size = 5 * 100_000 + 10
fun fill(arr: LongArray) {
    arr[0] = 0
    arr[1] = 3
    arr[2] = 8
    arr[3] = 24
    for (ii in 4 until size) {
        val i = ii.toLong()
        val count = (i + 1)
        if (count % 2L == 1L) {
            arr[ii] = (arr[ii - 2] - arr[ii - 4]) + arr[ii - 2] + 4L + (count - 4) * 4L + 8L * i / 2
        } else {
            arr[ii] = (arr[ii - 2] - arr[ii - 4]) + arr[ii - 2] + 4L + (count - 4) * 4L + 8L * count / 2
        }
    }
}

fun main() {
    scanner.apply {
        val arr = LongArray(size)
        fill(arr)
        val t = nextInt()
        for (testCase in 1..t) {
            val n = nextInt()
            println(arr[n - 1])
        }
    }
}
