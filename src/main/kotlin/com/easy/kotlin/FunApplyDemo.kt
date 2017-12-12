/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.easy.kotlin

fun testApply() {
    // 普通写法
    val list = mutableListOf<String>()
    list.add("A")
    list.add("B")
    list.add("C")
    println("普通写法 list = $list") // 常规写法 list = [A, B, C]
    println(list)

    // 使用 apply 函数写法
    val a = ArrayList<String>().apply {
        add("A")
        add("B")
        add("C")
        println("使用 apply 函数写法 this = $this")
    }
    println(a)
    // 等价于
    a.let { println(it) }
}

fun main(args: Array<String>) {
    testApply()
}
