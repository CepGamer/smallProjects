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
                    val func = { list: ArrayList<Int> ->
                        arrange(list)
                        println(list)
                    }

                    var a = arrayListOf(0, 1)
                    func(a)
                    a = arrayListOf(0, 1, 2)
                    func(a)
                    a = arrayListOf(1, 0)
                    func(a)
                }
            WhatToDo.A ->
                A()
            WhatToDo.B ->
                B()
        }
    }
}