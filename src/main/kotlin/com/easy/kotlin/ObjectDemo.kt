package com.easy.kotlin

import java.io.File


fun main(args: Array<String>) {
    println(User.username)
    println(User.password)
    User.hello()

    DataProcessor.process()

}


object User {
    val username: String = "admin"
    val password: String = "admin"
    fun hello() {
        println("Hello, object !")
    }
}


class DataProcessor {
    companion object DataProcessor {
        fun process() {
            println("I am processing data ...")
        }
    }
}