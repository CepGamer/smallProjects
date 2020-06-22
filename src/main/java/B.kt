import java.util.*

private val scanner = Scanner(System.`in`)

fun printResult(n: Int) {
    println(n)
}

fun B() {
    scanner.apply {
        val heading = next()
        val text = next()
        val letters = Array(init = { ArrayList<Int>() }, size = 26 + 1)
        heading.forEachIndexed { i, c ->
            letters[c - 'a'].add(i)
        }
        var hCount = 0
        var index = heading.length
        for (c in text) {
            if (letters[c - 'a'].isEmpty()) {
                return printResult(-1)
            }
            var insertionIndex = letters[c - 'a'].binarySearch(index)
            if (-(insertionIndex + 1) >= letters[c - 'a'].size) {
                insertionIndex = 0
                hCount++
            }
            var newIndex = -1
            newIndex = if (insertionIndex >= 0) {
                letters[c - 'a'][insertionIndex]
            } else {
                letters[c - 'a'][-insertionIndex - 1]
            }

            index = newIndex + 1
        }

        return printResult(hCount)
    }
}
