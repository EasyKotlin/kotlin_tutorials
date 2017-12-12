/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.easy.kotlin.chapter

class HelloOOP {

}


class Empty


fun main(args: Array<String>) {
    val empty = Empty()
    println(empty)
}


class Employee(val name: String, val workno: String, val sex: String, val age: Int) {
    override fun toString(): String {
        return "Employee(name='$name', workno='$workno', sex='$sex', age=$age)"
    }
}


class Department {
    var deptNo: Int = 0
    lateinit var deptName: String

    override fun toString(): String {
        return "Department(deptNo=$deptNo, deptName='$deptName')"
    }


}
