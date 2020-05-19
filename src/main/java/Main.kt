internal class Interval {
    var start: Int
    var end: Int

    constructor() {
        start = 0
        end = 0
    }

    constructor(s: Int, e: Int) {
        start = s
        end = e
    }

    override fun toString(): String {
        return "[$start, $end]"
    }
}

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        SadJavaClass().apply {
            println(
                merge(
                    arrayListOf(
                        Interval(27, 28),
                        Interval(15, 46),
                        Interval(5, 43),
                        Interval(7, 15),
                        Interval(46, 90),
                        Interval(7, 64),
                        Interval(18, 42),
                        Interval(67, 84),
                        Interval(48, 100),
                        Interval(21, 27),
                        Interval(26, 68)
                    )
                )
            )
        }
    }
}