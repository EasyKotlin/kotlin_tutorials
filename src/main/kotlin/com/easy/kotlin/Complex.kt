/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.easy.kotlin

import java.math.BigDecimal

class Complex {
    var real: Int = 0
    var image: Int = 0

    constructor()
    constructor(real: Int, image: Int) {
        this.real = real
        this.image = image
    }

    /**
     * 复数加法
     * (a+bi) + (c+di) = （ a + c ）+ ( b + d )i
     */
    operator fun plus(c: Complex): Complex {
        return Complex(this.real + c.real, this.image + c.image)
    }

    /**
     * 复数减法
     * (a+bi) - (c+di) = （a - c）+ (b - d)i
     */

    operator fun minus(c: Complex): Complex {
        return Complex(this.real - c.real, this.image - c.image)
    }

    /**
     * 复数乘法
     * (a+bi)(c+di) = ac-db + (bc+ad)i
     */
    operator fun times(c: Complex): Complex {
        return Complex(this.real * c.real - this.image * c.image, this.real * c.image + this.image * c.real)
    }

    override fun toString(): String {
        val img = if (image >= 0) "+ ${image}i" else "${image}i"
        return "$real ${img} "
    }
}

fun main(args: Array<String>) {
    val c1 = Complex(1, 1)
    val c2 = Complex(2, 2)
    val p = c1 + c2
    val m = c1 - c2
    val t = c1 * c2

    println(p)
    println(m)
    println(t)

    var bigDecimal1 = BigDecimal(100)
    var bigDecimal2 = BigDecimal(100)
    val tmp1 = bigDecimal1++
    val tmp2 = ++bigDecimal2
    println(tmp1)// 100
    println(tmp2)// 101
    println(bigDecimal1) // 101
    println(bigDecimal2) // 101


    var bigDecimal3 = BigDecimal(100)
    var bigDecimal4 = BigDecimal(100)
    val tmp3 = bigDecimal3--
    val tmp4 = --bigDecimal4
    println(tmp3)// 100
    println(tmp4)// 99
    println(bigDecimal3) // 99
    println(bigDecimal4) // 99




}


operator fun BigDecimal.inc() = this + BigDecimal.ONE
operator fun BigDecimal.dec() = this - BigDecimal.ONE
