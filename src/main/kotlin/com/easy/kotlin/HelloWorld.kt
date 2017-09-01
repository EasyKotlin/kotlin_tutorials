package com.easy.kotlin

import java.util.*

fun main(args: Array<String>) {
    println("Hello,World!")
    println(Date())
    forEachIndexedTest()
}


fun forEachIndexedTest(){
    val list = mutableListOf(1,2,3,4,5)
    list.forEachIndexed { index, i -> list[index] = i*i  }
    println(list)
}