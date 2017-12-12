/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.easy.kotlin.chapter.ch03


fun main(args: Array<String>) {
    val a = "abc"
    a.length
    val b: String? = null
    b?.length
}

/**
 * Kotlin 与 Java 完全无缝互操作
 */
fun getArrayList(): List<String> {
    val arrayList = ArrayList<String>()
    arrayList.add("A")
    arrayList.add("B")
    arrayList.add("C")
    return arrayList
}
