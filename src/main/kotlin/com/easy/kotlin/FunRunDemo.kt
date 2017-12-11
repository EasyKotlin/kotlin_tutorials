/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.easy.kotlin


fun testRunFun() {
    myfun()
    run({ myfun() })
    run { myfun() }
    run { println("A") }
}

fun main(args: Array<String>) {
    testRunFun()
}

/* 输出：

执行了 myfun 函数
执行了 myfun 函数
执行了 myfun 函数
A

*/
