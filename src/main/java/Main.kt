package smallPrograms.main

import A
import B
import C
import D
import SadJavaClass

enum class WhatToDo {
    JAVA,
    A,
    B,
    C,
    D
}

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val whatToDo = WhatToDo.valueOf(args.lastOrNull() ?: "A")

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
            WhatToDo.D ->
                D()
        }
    }
}
