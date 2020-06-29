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
                    println(pow(-1, 1, 20))
                    println(pow(2, 9, 5))
                    println(pow(71045970, 41535484, 64735492))
                }
            WhatToDo.A -> {
                val a = (1..3000).shuffled()
                println(3000)
                for (i in 0 until (3000 - 1)) {
                    println("${a[i]} ${a[i + 1]}")
                }
                A()
            }
            WhatToDo.B ->
                B()
        }
    }
}
