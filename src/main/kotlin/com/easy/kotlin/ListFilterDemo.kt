package com.easy.kotlin

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3, 4, 5, 6, 7)
    println(list.filter { it % 2 == 1 }) // lambda表达式
    println(list.filter({ it % 2 == 1 }))
    println(list.filter({ it -> it % 2 == 1 }))

    val isOdd = { it: Int -> it % 2 == 1 }
    println(list.filter(isOdd))

    val sum = fun(x: Int, y: Int): Int { return x + y }
    println(sum(1, 1)) // 2

    println(multiply(2, 2)) // 4
}

fun multiply(x: Int, y: Int): Int {
    return x * y
}