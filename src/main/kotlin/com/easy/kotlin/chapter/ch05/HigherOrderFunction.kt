/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.easy.kotlin.chapter

// http://www.jianshu.com/p/61db795324bd
// 简单好用的 Kotlin 类型别名, 我们使用 G，F，H 声明了3个函数类型（有点类似Java 中的接口类型的概念）
typealias G = (String) -> Int
typealias F = (Int) -> Boolean
typealias H = (String) -> Boolean

fun main(args: Array<String>) {
    val strList = listOf("a", "ab", "abc", "abcd", "abcde", "abcdef", "abcdefg")
    // 非常好用的流式 API filter，flat，map 等等
    val mstrList = strList.filter(h(g, f))
    println(mstrList)


    mstrList.forEachIndexed { index, value ->
        println("$value = ${value.length}")
    }

    println(foo(1, { it -> it + 1 }))
    println(foo(10, { it -> it * it }))
}

// 简单直接的函数定义
val f = fun(x: Int) = x % 2 == 1 // 判断输入的Int是否奇数
val g = fun(s: String) = s.length // 返回输入的字符串参数的长度
// 简单优雅的高阶函数定义（复合函数）： compose(f, g) = f(g(*))
val h = fun(g: G, f: F): H {
    return { f(g(it)) }
}


fun <T> foo(x: Int = 1, transform: (Int) -> T = { it as T }) = transform(x)
