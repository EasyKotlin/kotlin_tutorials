package com.easy.kotlin

import java.util.*


fun forEachIndexedTest() {
    val list = mutableListOf(1, 2, 3, 4, 5)
    list.forEachIndexed { index, i -> list[index] = i * i }
    println(list)
}


fun letFun() {
    val listWithNulls = listOf("A", "B", "C", null, null, "D")
    listWithNulls.forEach { it?.let { println(it) } }
}

fun main(args: Array<String>) {
    println(Date())
    forEachIndexedTest()
    letFun()
}
