/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.easy.kotlin.chapter


enum class Direction {
    NORTH, SOUTH, WEST, EAST // 每个枚举常量都是一个对象, 用逗号分隔
}


enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

fun main(args: Array<String>) {
    val east = Direction.EAST
    println(east.name)
    println(east.ordinal)

    println(Direction.NORTH.name)
    println(Direction.NORTH.ordinal)

    val c = Color.GREEN
    println(c.rgb)
    println(c.name)
    println(c.ordinal)

}
