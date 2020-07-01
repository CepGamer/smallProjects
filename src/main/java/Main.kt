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
                    println(pow(2, 9, 5))
                    println(pow(71045970, 41535484, 64735492))
                }
            WhatToDo.A -> {
                A()
            }
            WhatToDo.B ->
                B()
        }
    }
}
