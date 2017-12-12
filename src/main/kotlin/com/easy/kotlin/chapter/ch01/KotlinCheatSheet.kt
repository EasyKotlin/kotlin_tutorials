/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.easy.kotlin.chapter.ch01

fun main(args: Array<String>) {
//    println("Hello,World")
//    println(isLeapYear(2017))
//    println(isLeapYear(2020))
//    casesWhen(1)
//    casesWhen("hello")
//    casesWhen('X')
//    casesWhen(null)
//    println(fact(10))
    println(sumFact(10))
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

fun casesWhen(obj: Any?) {
    when (obj) {
        0, 1, 2, 3, 4, 5, 6, 7, 8, 9 -> println("${obj} ===> 这是一个0-9之间的数字")
        "hello" -> println("${obj} ===> 这个是字符串hello")
        is Char -> println("${obj} ===> 这是一个 Char 类型数据")
        else -> println("${obj} ===> else类似于Java中的 case-switch 中的 default")
    }
    var x = 10
    when{
        x in 6..10  ->  println("大于6小于等于10")
        x < 6 -> println("小于6")
        else -> println("其他")
    }
}

//编写一个 Kotlin 程序在屏幕上输出1！+2！+3！+……+10！的和
fun sumFact(n: Int): Int {
    var sum = 0
    for (i in 1..n) {
        sum += fact(i)
    }
    return sum
}


fun fact(n: Int): Int {
    var result = 1
    when (n) {
        0, 1 -> result = 1
        else -> result = n * fact(n - 1)
    }
    return result
}
