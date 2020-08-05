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
                    println(compareVersion("1.0", "1.0.1"))
                }
            WhatToDo.A -> {
                A()
            }
            WhatToDo.B ->
                B()
        }
    }
}
