package com.easy.kotlin


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
