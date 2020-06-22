package smallPrograms.main

import A
import B
import SadJavaClass

enum class WhatToDo {
    JAVA,
    A,
    B
}

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val whatToDo = WhatToDo.A

        when (whatToDo) {
            WhatToDo.JAVA ->
                SadJavaClass().apply {
                    println(firstMissingPositive(arrayListOf(8, 89)))
                    println(firstMissingPositive((arrayListOf(3, 30, 34, 5, 9))))
                    println(firstMissingPositive((arrayListOf(1, 2, 0, 5, 9))))
                    println(firstMissingPositive((arrayListOf(3, 4, 34, 5, 1))))
                    println(firstMissingPositive((arrayListOf(-3, -30, -34, -5, -9))))
                }
            WhatToDo.A ->
                A()
            WhatToDo.B ->
                B()
        }
    }
}