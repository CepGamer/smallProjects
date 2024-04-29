package smallPrograms.main

import A
import B
import C
import SadJavaClass

enum class WhatToDo {
    JAVA,
    A,
    B,
    C
}

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val whatToDo =  WhatToDo.C

        when (whatToDo) {
            WhatToDo.JAVA ->
                SadJavaClass().apply {
                }
            WhatToDo.A -> {
                A()
            }
            WhatToDo.B ->
                B()
            WhatToDo.C ->
                C()
        }
    }
}
