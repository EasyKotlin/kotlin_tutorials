package com.easy.kotlin

fun String.lastChar(): String {
    if (this.length == 0) {
        return ""
    }
    return this[this.length - 1].toString()
}

fun String.firstChar(): String {
    if (this.length == 0) {
        return ""
    }
    return this[0].toString()
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

fun main(args: Array<String>) {
    val str = "abc"
    println(str.firstChar())
    println(str.lastChar())

    val list = mutableListOf(1, 2, 3, 4, 5, 6, 7)
    val result = list.filter {
        it % 2 == 1
    }
    println(result)
}