/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.easy.kotlin.chapter

fun myfun(): String {
    println("执行了 myfun 函数")
    return "这是 myfun 的返回值"
}

fun testLetFun() {
    1.let { println(it) } // 1
    "ABC".let { println(it) } // ABC
    // 执行完函数 myfun(), 返回值传给 let 函数
    myfun().let {
        print(it)
    }
}

fun main(args: Array<String>) {
    testLetFun()
}
