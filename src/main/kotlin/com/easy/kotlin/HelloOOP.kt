package com.easy.kotlin

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
