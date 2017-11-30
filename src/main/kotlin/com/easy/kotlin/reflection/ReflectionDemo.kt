/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.easy.kotlin.reflection

import java.lang.reflect.ParameterizedType
import kotlin.reflect.KTypeParameter
import kotlin.reflect.full.declaredFunctions

open class BaseContainer<T>

class Container<T : Comparable<T>> : BaseContainer<Int> {
    var elements: MutableList<T>

    constructor(elements: MutableList<T>) {
        this.elements = elements
    }

    fun sort(): Container<T> {
        elements.sort()
        return this
    }

    override fun toString(): String {
        return "Container(elements=$elements)"
    }
}


fun fooContainer() {
    val container = Container(mutableListOf<Int>(1, 3, 2, 5, 4, 7, 6))
    println(container)
    container.sort()
    println(container)

    val kClass = container::class // 获取KClass对象

    val jkCLass = kClass.java
    println(jkCLass)
//    val staticKClass = Container::class
//    println(staticKClass)

    val typeParameters = kClass.typeParameters // 获取类型参数typeParameters信息，也即泛型信息

    val kTypeParameter: KTypeParameter = typeParameters[0]
    println(kTypeParameter.isReified) // false
    println(kTypeParameter.name) // T
    println(kTypeParameter.upperBounds) // [kotlin.Comparable<T>]
    println(kTypeParameter.variance) // INVARIANT

    val constructors = kClass.constructors
    for (KFunction in constructors) {
        KFunction.parameters.forEach {
            val name = it.name
            val type = it.type
            println("name = ${name}") // elements
            println("type = ${type}") // kotlin.collections.MutableList<T>
            for (KTypeProjection in type.arguments) {
                println(KTypeProjection.type) // T
            }
        }
    }

    kClass.declaredFunctions
    kClass.members
    kClass.typeParameters

    val jClass = container.javaClass // 获取Java Class对象

    val parameterizedType = jClass.genericSuperclass as ParameterizedType // ParameterizedType represents a parameterized type such a Collection<String>
    val actualTypeArguments = parameterizedType.actualTypeArguments
    for (type in actualTypeArguments) {
        val typeName = type.typeName
        println("typeName = ${typeName}")
    }

    val rawType = parameterizedType.rawType
    println("rawType = ${rawType}")
}

fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
    return { x -> f(g(x)) }
}

fun isOdd(x: Int) = x % 2 != 0
fun length(s: String) = s.length


class A<T>
open class C<T>
class B<T> : C<Int>()

fun fooA() {
    // 无法在此处获得运行时 T 的具体类型！！！
    val parameterizedType = A<Int>()::class.java.genericSuperclass as ParameterizedType
    val actualTypeArguments = parameterizedType.actualTypeArguments
    for (type in actualTypeArguments) {
        val typeName = type.typeName
        println("typeName = ${typeName}")
    }
}

fun fooB() {
    // 当继承了父类 C<Int> 的时候，在此处获得运行时 genericSuperclass T 的具体类型
    val parameterizedType = B<Int>()::class.java.genericSuperclass as ParameterizedType
    val actualTypeArguments = parameterizedType.actualTypeArguments
    for (type in actualTypeArguments) {
        val typeName = type.typeName
        println("typeName = ${typeName}")
    }
}


fun main(args: Array<String>) {
    fooContainer()
//    fooA()
//    fooB()

//    val nums = listOf(1, 2, 3)
//    val filteredNums = nums.filter(::isOdd)
//    println(filteredNums)
//
//    testReflectProperty()
//
//    testBindRef()

}


var one = 1
fun testReflectProperty() {
    println(::one.get()) // 1
    ::one.set(2)
    println(one)         // 2
}


fun testBindRef() {
    val digitRegex = "\\d+".toRegex()
    digitRegex.matches("7") // true
    digitRegex.matches("6") // true
    digitRegex.matches("5") // true
    digitRegex.matches("X") // false

    val isDigit = digitRegex::matches // 绑定函数 isNumber = numberRegex::matches
    isDigit("7")// true
    isDigit("6")// true
    isDigit("5")// true
    isDigit("X")// true
}



