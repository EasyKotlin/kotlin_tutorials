package com.easy.kotlin

abstract class Shape {
    open var width: Double = 0.0
    open var heigth: Double = 0.0
    open var radius: Double = 0.0
    abstract fun area(): Double

    open fun onClick() {
        println("Shape is Clicked!")
    }
}

class Rectangle(override var width: Double, override var heigth: Double) : Shape() {
    override fun area(): Double {
        return width * heigth
    }
}

class Circle(override var radius: Double) : Shape() {
    override fun area(): Double {
        return Math.PI * radius * radius
    }

    override fun onClick() {
        println("${this::class.simpleName} is Clicked!")
    }
}

class Triangle(override var width: Double, override var heigth: Double) : Shape() {
    override fun area(): Double {
        return width * heigth / 2
    }
}

fun main(args: Array<String>) {
    val rect = Rectangle(1.0, 2.0)
    println(rect is Shape) // true

//    val shape = Shape() // 抽象类是不能够被初始化的

    val circle = Circle(10.0)
    println(circle.area()) // 314.1592653589793
    circle.onClick()

}
