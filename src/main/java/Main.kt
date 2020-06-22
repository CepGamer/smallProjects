package smallPrograms.main

import SadJavaClass

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        SadJavaClass().apply {
            println(firstMissingPositive(arrayListOf(8, 89)))
            println(firstMissingPositive((arrayListOf(3, 30, 34, 5, 9))))
            println(firstMissingPositive((arrayListOf(1, 2, 0, 5, 9))))
            println(firstMissingPositive((arrayListOf(3, 4, 34, 5, 1))))
            println(firstMissingPositive((arrayListOf(-3, -30, -34, -5, -9))))
        }
    }
}