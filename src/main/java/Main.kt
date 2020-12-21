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
        val whatToDo = WhatToDo.B

        when (whatToDo) {
            WhatToDo.JAVA ->
                SadJavaClass().apply {
                }
            WhatToDo.A -> {
                A()
            }
            WhatToDo.B ->
                B()
        }
    }
}
