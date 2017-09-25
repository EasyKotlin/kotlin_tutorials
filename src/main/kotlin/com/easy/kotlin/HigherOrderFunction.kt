package com.easy.kotlin

// http://www.jianshu.com/p/61db795324bd
// 简单好用的 Kotlin 类型别名, 我们使用 G，F，H 声明了3个函数类型（有点类似Java 中的接口类型的概念）
typealias G = (String) -> Int
typealias F = (Int) -> Boolean
typealias H = (String) -> Boolean

fun main(args: Array<String>) {
    val h = h(::g, ::f)
    val strList = listOf("a", "ab", "abc", "abcd", "abcde", "abcdef", "abcdefg")
    // 非常好用的流式 API filter，flat，map 等等
    val mstrList = strList.filter(h)
    println(mstrList)
    mstrList.forEachIndexed { index, value ->
        println("$value = ${value.length}")
    }

    println(foo(1, { it -> it + 1 }))
    println(foo(10, { it -> it * it }))
}

// 简单直接的函数定义
fun f(x: Int) = x % 2 != 0

fun g(s: String) = s.length
// 简单优雅的高阶函数定义（复合函数）： compose(f, g) = f(g(*))
fun h(g: G, f: F): H {
    return { x -> f(g(x)) }
}


fun <T> foo(x: Int = 1, transform: (Int) -> T = { it as T }) = transform(x)