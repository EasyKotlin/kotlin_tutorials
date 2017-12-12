/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.easy.kotlin.chapter.ch01

import java.text.SimpleDateFormat
import java.util.*

data class PersonKotlin(val id: Int, val name: String)

fun getArrayList(): List<String> {  // (1)
    val arrayList = ArrayList<String>()  // (2)
    arrayList.add("A")
    arrayList.add("B")
    arrayList.add("C")
    return arrayList
}


fun String.firstChar(): String { // 给 String 类扩展一个firstChar() 函数
    if (this.length == 0) {
        return ""
    }
    return this[0].toString()
}


fun main(args: Array<String>) {
    println("Hello, world!")
    println(SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date()))
}

