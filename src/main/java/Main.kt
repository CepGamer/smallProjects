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
        val whatToDo = WhatToDo.JAVA

        when (whatToDo) {
            WhatToDo.JAVA ->
                SadJavaClass().apply {
                    println(uniquePaths(1, 1))
                    println(uniquePaths(2, 2))
                    println(uniquePaths(3, 3))
                    println(uniquePaths(102, 1))
                    println(uniquePaths(102, 2))
                }
            WhatToDo.A ->
                A()
            WhatToDo.B ->
                B()
        }
    }
}