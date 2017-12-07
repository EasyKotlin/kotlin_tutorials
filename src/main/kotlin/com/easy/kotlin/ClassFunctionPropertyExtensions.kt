package com.easy.kotlin

fun String.firstChar(): String {
    if (this.length == 0) {
        return ""
    }
    return this[0].toString()
}

fun String.lastChar(): String {
    if (this.length == 0) {
        return ""
    }
    return this[this.length - 1].toString()
}


fun String.inc(): String {
    var result = ""
    this.map { result += it + 1 }
    return result
}


fun <T> List<T>.filter(predicate: (T) -> Boolean): MutableList<T> {
    val result = ArrayList<T>()
    this.forEach {
        if (predicate(it)) {
            result.add(it)
        }
    }
    return result
}

var <T> MutableList<T>.firstElement: T
    get() {
        return this[0]
    }
    set(value) {
        this[0] = value
    }

var <T> MutableList<T>.lastElement: T
    get() {
        return this[this.size - 1]
    }
    set(value) {
        this[this.size - 1] = value
    }


fun main(args: Array<String>) {
    "abc".firstChar()

    val str = "abc"
    println(str.firstChar()) // a
    println(str.lastChar()) // c
    println(str.inc()) //

    val list = mutableListOf(1, 2, 3, 4, 5, 6, 7)
    val result = list.filter {
        it % 2 == 1
    }
    println(result) // [1, 3, 5, 7]

    println("list = ${list}") // list = [1, 2, 3, 4, 5, 6, 7]
    println(list.firstElement) // 1
    println(list.lastElement) // 7

    list.firstElement = -1
    list.lastElement = -7

    println("list = ${list}") // list = [-1, 2, 3, 4, 5, 6, -7]
    println(list.firstElement) // -1
    println(list.lastElement) // -7
}