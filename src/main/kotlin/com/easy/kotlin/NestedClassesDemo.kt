package com.easy.kotlin

class NestedClassesDemo {
    class Outer {
        private val zero: Int = 0
        val one: Int = 1

        inner class Inner {
            fun accessOuter() = {
                println(zero) // works
                println(one) // works
            }

        }
    }


    class AnonymousInnerClassDemo {
        var isRunning = false
        fun doRun() {
            Thread(object : Runnable { // 匿名内部类
                override fun run() {
                    isRunning = true
                    println("doRun : i am running, isRunning = $isRunning")
                }
            }).start()
        }
    }
}


fun doStop() {
    var isRunning = true
    Thread({
        isRunning = false
        println("doStop: i am not running, isRunning = $isRunning")
    }).start()
}

fun doWait() {
    var isRunning = true
    val wait = Runnable {
        isRunning = false
        println("doWait: i am waiting, isRunning = $isRunning")
    }
    Thread(wait).start()
}

fun doNotify() {
    var isRunning = true
    val wait = {
        isRunning = false
        println("doNotify: i notify, isRunning = $isRunning")
    }
    Thread(wait).start()
}


fun main(args: Array<String>) {
    val innerClass = NestedClassesDemo.Outer().Inner().accessOuter()
}
