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
                    println(prettyPrint(3))
                    println(prettyPrint(4))
                }
            WhatToDo.A ->
                A()
            WhatToDo.B ->
                B()
        }
    }
}