/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.easy.kotlin

fun testWithFun() {
    // 普通写法
    val list = mutableListOf<String>()
    list.add("A")
    list.add("B")
    list.add("C")
    println("常规写法 list = $list") // 常规写法 list = [A, B, C]

    // 使用 with 函数写法
    with(ArrayList<String>()) {
        add("A")
        add("B")
        add("C")
        println("使用 with 函数写法 this = $this") // 使用 with 函数的写法 this = [A, B, C]
    }.let {
        println(it) // kotlin.Unit
    }
}

fun main(args: Array<String>) {
    testWithFun()
}
