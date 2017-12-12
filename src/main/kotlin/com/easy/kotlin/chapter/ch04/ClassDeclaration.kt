/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.easy.kotlin.chapter

class ClassDeclaration

class AnEmptyClass

fun main(args: Array<String>) {
    val anEmptyClass = AnEmptyClass()
    println(anEmptyClass)
    println(anEmptyClass is AnEmptyClass)
    println(anEmptyClass::class)

    val person = Person("Jack", 29, "M")
    println("person = ${person}")

    val person1 = Person1()
    person1.name = "Jack"
    person1.age = 29
    person1.sex = "M"
    println("person1 = ${person1}")

    val person21 = Person2()
    person21.name = "Jack"
    person21.age = 29
    person21.sex = "M"
    println("person21 = ${person21}")

    val person22 = Person2("Jack", 29)
    person22.sex = "M"
    println("person22 = ${person22}")

    val person23 = Person2("Jack", 29, "M")
    println("person23 = ${person23}")
}

class Person(var name: String, var age: Int, var sex: String) { // 一种简洁语法，可以通过主构造器来定义属性并初始化属性值（可以是var或val）
    override fun toString(): String {
        return "Person(name='$name', age=$age, sex='$sex')"
    }
}

class Person1 {
    lateinit var name: String
    var age: Int = 0
    lateinit var sex: String
    override fun toString(): String {
        return "Person1(name='$name', age=$age, sex='$sex')"
    }
}

class Person2 {
    lateinit var name: String
    var age: Int = 0
    lateinit var sex: String

    constructor()

    constructor(name: String) {
        this.name = name
    }

    constructor(name: String, age: Int) : this(name) {
        this.name = name
        this.age = age
    }

    constructor(name: String, age: Int, sex: String) : this(name, age) {
        this.name = name
        this.age = age
        this.sex = sex
    }

    override fun toString(): String {
        return "Person1(name='$name', age=$age, sex='$sex')"
    }
}
