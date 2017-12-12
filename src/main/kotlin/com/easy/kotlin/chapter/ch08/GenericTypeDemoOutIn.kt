/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.easy.kotlin.chapter


fun main(args: Array<String>) {
    val fruits: MutableList<Fruit> = mutableListOf(Fruit(), Fruit(), Fruit())
    GenericTypeDemoOutIn.addFruit(fruits)
    GenericTypeDemoOutIn.getFruit(fruits)

    val apples: MutableList<Apple> = mutableListOf(Apple(), Apple(), Apple())
    GenericTypeDemoOutIn.getFruit(apples)
//    GenericTypeDemoOutIn.addFruit(apples) // type mismatch, <in Fruit>只能传入Fruit类型及其超类型

    val foods: MutableList<Food> = mutableListOf(Food(), Food(), Food())
    GenericTypeDemoOutIn.addFruit(foods)
//    GenericTypeDemoOutIn.getFruit(foods) // type mismatch, <in Fruit>只能传入Fruit类型及其超类型
}

object GenericTypeDemoOutIn {

    fun addFruit(superFruit: MutableList<in Fruit>) { // <? super Fruit>
// superFruit 限制为只能传入 Fruit 类型及其父类型，
// 这样我们就可以安全地向superFruit 添加 Fruit 类型了。
        superFruit.add(Fruit())
        superFruit.add(Apple())
        superFruit.add(Banana())
        superFruit.add(Grape())
//        superFruit.add(Food()) // Type mismatch，不能放入 Fruit 的超类型
        println("superFruit = ${superFruit}")

//        val f0: Fruit = superFruit[0] // Any? , Type mismatch
//        val f1: Fruit = superFruit[1] // Any? , Type mismatch

    }

    fun getFruit(extendsFruit: MutableList<out Fruit>) { // <? extends Fruit>
// extendsFruit 传入的可能为 MutableList<Fruit> ,
//     也可能为  MutableList<Apple> ,
//     也可能为  MutableList<Banana> ,
//     也可能为  MutableList<Grape> 等等，所以我们不能向 extendsFruit 中写入 Fruit()，Apple()对象，
// 因为编译器不知道会传入什么样的 fruit 类型

//        extendsFruit.add(Fruit()) // out 投射类型， 禁止使用 add
//        extendsFruit.add(Apple()) // out 投射类型， 禁止使用 add
        extendsFruit.forEach { println(it) }
    }

}


fun <T> countGreaterThan(elements: Array<T>, target: T): Int {
    var count = 0
    for (e in elements){
        //        if (e > target) {// 编译不通过，除了 Short, Int 等原始类型，其他的类并不一定重载了操作符 >
//            ++count
//        }
    }

    return count
}

interface Comparable<T> {
    operator fun compareTo(o: T): Int
}

fun <T : Comparable<T>> countGreaterThan(elements: Array<T>, target: T): Int { // T : Comparable<T> ，其中 Comparable<T> 是类型 T 的上界
//    也就是告诉编译器，类型参数 T 代表的都是实现了 Comparable<T> 接口的类，这样等于告诉编译器它们都实现了compareTo方法。
    var count = 0
    for (e in elements){
        if (e > target) {
            ++count
        }
    }

    return count
}
