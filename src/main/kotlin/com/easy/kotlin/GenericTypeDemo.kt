package com.easy.kotlin

import java.util.*

val map = mutableMapOf<Int, String>(1 to "a", 2 to "b", 3 to "c")

open class Food
open class Fruit : Food()
class Apple : Fruit()
class Banana : Fruit()
class Grape : Fruit()


object GenericTypeDemo {

    fun addFruit(fruit: MutableList<Fruit>) {
        // TODO
    }

    fun getFruit(fruit: MutableList<Fruit>) {
        // TODO
    }

    fun addApple(apple: MutableList<Apple>) {
        // TODO
    }

    fun getApple(apple: MutableList<Apple>) {
        // TODO
    }

}

fun main(args: Array<String>) {
    val fruits: MutableList<Fruit> = mutableListOf(Fruit(), Fruit(), Fruit())
    GenericTypeDemo.addFruit(fruits)
    GenericTypeDemo.getFruit(fruits)

    val apples: MutableList<Apple> = mutableListOf(Apple(), Apple(), Apple())
//    GenericTypeDemo.addFruit(apples) // type mismatch
//    GenericTypeDemo.getFruit(apples) // type mismatch
    GenericTypeDemo.addApple(apples)
    GenericTypeDemo.getApple(apples)

    testContainer()
    testGenerator()
    testGenericClass()


//    MutableList<Fruit>::class
    MutableList::class
}

//泛型类
class Container<K, V>(var key: K, var value: V) {
    override fun toString(): String {
        return "Container(key=$key, value=$value)"
    }
}

fun testContainer() {
    val container = Container<Int, String>(1, "A")
    println("container = ${container}")
}

//泛型接口
interface Generator<T> {
    operator fun next(): T
}

fun testGenerator() {
    val gen = object : Generator<Int> {
        override fun next(): Int {
            return Random().nextInt(10)
        }
    }
    println(gen.next())
}


// 泛型方法
class GenericClass {
    fun <T> console(t: T) {
        println(t)
    }
}

interface GenericInterface {
    fun <T> console(t: T)
}

fun <T : Comparable<T>> gt(x: T, y: T): Boolean {
    return x > y
}

//fun <T> gt1(x: T, y: T): Boolean {
//    return x > y // 编译不通过
//}


fun testGenericClass() {
    val gen = GenericClass()
    gen.console("X")
}


