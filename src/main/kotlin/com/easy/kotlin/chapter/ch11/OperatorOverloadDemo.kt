/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.easy.kotlin.chapter.ch11

import java.math.BigDecimal

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


    val bd1 = BigDecimal.ONE
    val bd2 = BigDecimal.ONE
    val bdbd = bd1 > bd2
    val bdeq = bd1 == bd2
    val bdeqeq = bd1 === bd2
    println(bdbd) // false
    println(bdeq) // true
    println(bdeqeq) // true

    val p1 = Point(1, 1)
    val p2 = Point(1, 1)
    val p3 = Point(1, 3)
    println(-p1)
    println(p1 == p2) // true
    println(p1 == p3) // false
    println(p1 >= p2) // true
    println(p3 > p1) // true

}


class Point(val x: Int, val y: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Point

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }

    operator fun compareTo(other: Point): Int {
        val thisNorm = Math.sqrt((this.x * this.x + this.y * this.y).toDouble())
        val otherNorm = Math.sqrt((other.x * other.x + other.y * other.y).toDouble())
        return thisNorm.compareTo(otherNorm)
    }

    operator fun unaryMinus() = Point(-x, -y)
    override fun toString(): String {
        return "Point(x=$x, y=$y)"
    }


}
