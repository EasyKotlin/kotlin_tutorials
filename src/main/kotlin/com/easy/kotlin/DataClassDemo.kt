package com.easy.kotlin

data class LoginUser(val username: String, val password: String)

interface DataInterface

data class LoginUser2(var username: String, var password: String) : DataInterface {

}


data class DataEmpty(var param: String) // 数据类至少有1个参数
//data class DataClassDemoPPP(param: String) // 数据类至少有1个参数



fun main(args: Array<String>) {
    val loginUser = LoginUser("root", "111111")

    println(loginUser)
    println(loginUser.username)
    println(loginUser.password)

    println(loginUser.component1())
    println(loginUser.component2())

    val (username, password) = loginUser // 解构声明
    println("username = ${username}")
    println("password = ${password}")

}
