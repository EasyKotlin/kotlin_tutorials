/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.easy.kotlin.chapter.ch03

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
