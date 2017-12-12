/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.easy.kotlin.chapter.ch02

import java.lang.Integer.parseInt

fun main(args: Array<String>) {
    println(max(1, 2))
    println(isLeapYear(2017)) // false
    println(isLeapYear(2020)) // true

    casesWhen(1)
    casesWhen("hello")
    casesWhen('X')
    casesWhen(null)
}

fun casesWhen(obj: Any?) {
    when (obj) {        0, 1, 2, 3, 4, 5, 6, 7, 8, 9 -> println("${obj} ===> 这是一个0-9之间的数字")
        "hello" -> println("${obj} ===> 这个是字符串hello")
        is Char -> println("${obj} ===> 这是一个 Char 类型数据")
        else -> println("${obj} ===> else类似于Java中的 case-switch 中的 default")
    }
}

fun isLeapYear(year: Int): Boolean {
    var isLeapYear: Boolean
    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
        isLeapYear = true
    } else {
        isLeapYear = false
    }
    return isLeapYear
}


fun max(a: Int, b: Int): Int {    // 表达式返回值
    val max = if (a > b) a else b
    return max
}

fun max3(a: Int, b: Int): Int {
    val max = if (a > b) {
        print("Max is a")
        a // 最后的表达式作为该代码块的值

    } else {
        print("Max is b")
        b // 同上
    }
    return max
}


fun switch(x: Int) {
    val s = "123"
    when (x) {        -1, 0 -> print("x == -1 or x == 0")
        1 -> print("x == 1")
        2 -> print("x == 2")
        8 -> print("x is 8")
        parseInt(s) -> println("x is 123")
        else -> { // 注意这个块
            print("x is neither 1 nor 2")
        }
    }
}

