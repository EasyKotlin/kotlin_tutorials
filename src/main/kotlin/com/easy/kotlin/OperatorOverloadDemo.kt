package com.easy.kotlin

class BoxInt(var i: Int) {

    operator fun times(x: BoxInt) = BoxInt(i * x.i)

    override fun toString(): String {
        return i.toString()
    }
}

operator fun BoxInt.plus(x: BoxInt) = BoxInt(this.i + x.i)

fun main(arg: Array<String>) {
    val a = BoxInt(3)
    val b = BoxInt(7)

    a + b
    a * b

    println(a + b) //10
    println(a * b) //21

    1 in 0..9
}
