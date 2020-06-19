package smallPrograms.main

import SadJavaClass

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        SadJavaClass().apply {
            println(largestNumber(listOf(8, 89)))
            println(largestNumber(listOf(3, 30, 34, 5, 9)))
            println(largestNumber(listOf(3, 303, 54, 55, 89, 90, 99, 98, 9231, 990)))
            println(largestNumber(listOf(931, 94, 209, 448, 716, 903, 124, 372, 462, 196, 715, 802, 103, 740, 389, 872, 615, 638, 771, 829, 899, 999, 29, 163, 342, 902, 922, 312, 326, 817, 288, 75, 37, 286, 708, 589, 975, 747, 743, 699, 743, 954, 523, 989, 114, 402, 236, 855, 323, 79, 949, 176, 663, 587, 322)))
        }
    }
}