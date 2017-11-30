package com.easy.kotlin

class A {
    val a = 1

    class B {
        val b = 2

        class C {
            val c = 3
            fun printC() {
//                println(a)
//                println(b)
                println(c)
            }

        }
    }
}


class D {
    val d = 4

    inner class E {
        val e = 5

        inner class F {
            val f = 6

            fun printlnF() {
                println(f)
                println(e)
                println(d)
            }
        }

    }
}


fun anonymousInnerClassDemo() {
    Thread {
        println("RUN")
    }.start()

    Thread(Runnable { println("RUN") }).start()

    Thread(object : Runnable {
        override fun run() {
            println("RUN")
        }
    }).start()
}

fun main(args: Array<String>) {
    val classC = A.B.C().printC()

    val classF = D().E().F().printlnF()

    anonymousInnerClassDemo()

}
