/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.easy.kotlin.chapter

fun main(args: Array<String>) {
    val emptyList: List<Int> = listOf()
    val emptySet: Set<Int> = setOf()
    val emptyMap: Map<Int, String> = mapOf()

    val list = listOf(1, 2, 3, 4, 5, 6, 7)
    val mutableList = mutableListOf("a", "b", "c")

    val set = setOf(1, 2, 3, 4, 5, 6, 7)
    val mutableSet = mutableSetOf("a", "b", "c")

    val map = mapOf(1 to "a", 2 to "b", 3 to "c")
    val mutableMap = mutableMapOf(1 to "X", 2 to "Y", 3 to "Z")



    list.forEach {
        println(it)
    }


    set.forEach {
        println(it)
    }


    map.forEach {
        println("K = ${it.key}, V = ${it.value}")
    }



    list.forEachIndexed { index, value ->
        println("list index = ${index} , value = ${value}")
    }

    set.forEachIndexed { index, value ->
        println("set index = ${index} , value = ${value}")
    }

    mutableList.forEach {
        println(it)
    }

    val result1 = list.filter { it % 2 == 1 }

    val funlist: List<(Int) -> Boolean> =
            listOf({ it -> it % 2 == 0 },
                    { it -> it % 2 == 1 })

    val result2 = list.filter(funlist[0])
    val result3 = list.filter(funlist[1])

    println("result1 = ${result1}")
    println("result2 = ${result2}")
    println("result3 = ${result3}")

    list.filterIndexed { index, it -> index % 2 == 0 && it > 3 }


    list.map { it * it } // [1, 4, 9, 16, 25, 36, 49]
    set.map { it + 1 } // [2, 3, 4, 5, 6, 7, 8]
    map.map { it.value + "$" } // [a$, b$, c$]

    val strlist = listOf("a", "b", "c")
    println(strlist.map { it -> listOf(it + 1, it + 2, it + 3, it + 4) })
    println(strlist.map { it -> listOf(it + 1, it + 2, it + 3, it + 4) }.flatten())
    println(strlist.flatMap { it -> listOf(it + 1, it + 2, it + 3, it + 4) })

    val studentList = listOf(
            Student(1, "Jack", 18, 90),
            Student(2, "Rose", 17, 80),
            Student(3, "Alice", 16, 70)
    )
    println(studentList.filter { it.age >= 18 })
    println(studentList.filter { it.score < 80 })


    val dupList = listOf(1, 1, 2, 2, 3, 3, 3)
    println(dupList.distinct()) // [1, 2, 3]

}

fun orderFun(){
    val list = listOf(1, 2, 3, 4, 5, 6, 7)
    val set = setOf(1,3,2)

    list.reversed() // [7, 6, 5, 4, 3, 2, 1]
    set.reversed() // [2, 3, 1]

    list.sorted()
    set.sorted()
}


data class Student(var id: Long, var name: String, var age: Int, var score: Int) {
    override fun toString(): String {
        return "Student(id=$id, name='$name', age=$age, score=$score)"
    }
}
