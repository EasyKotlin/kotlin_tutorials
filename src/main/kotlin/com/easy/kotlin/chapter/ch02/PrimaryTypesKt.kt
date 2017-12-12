/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.easy.kotlin.chapter.ch02

fun main(args: Array<String>) {
    test1()
}

fun test1() {
    val x: Int = 123
    val y: Int = 123

    println(x == y)
    println(x === y)

    val z: Int = 456
    val w: Int = 456
    println(z == w)
    println(z === w)

    val a: Long = 789
    val b: Int = 1010
    println(a<b)
    //println(a!=b) //Error:(22, 13) Kotlin: Operator '!=' cannot be applied to 'Long' and 'Int'
    //println(a==b) //Error:(23, 13) Kotlin: Operator '==' cannot be applied to 'Long' and 'Int'
    println(a.compareTo(b))
}
