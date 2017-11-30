/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.easy.kotlin.annotation

import java.util.*
import kotlin.reflect.KClass
import kotlin.reflect.full.declaredFunctions

@Target(AnnotationTarget.CLASS,
        AnnotationTarget.FUNCTION,
        AnnotationTarget.VALUE_PARAMETER,
        AnnotationTarget.EXPRESSION)
@Retention(AnnotationRetention.RUNTIME)
@Repeatable
@MustBeDocumented
annotation class TestCase(val id: String)

annotation class TestCasee(val id: Int)
annotation class TestCaseee(val id: Array<String>)
annotation class TestCaseeee(val id: Run)
annotation class TestCaseeeeee(val id: KClass<String>)

//annotation class TestCaseeeee(val id: Array<Int>)
//annotation class TestCaseeeeee(val id: SwordTest)


@Target(AnnotationTarget.CLASS,
        AnnotationTarget.FUNCTION,
        AnnotationTarget.VALUE_PARAMETER,
        AnnotationTarget.EXPRESSION)
@Retention(AnnotationRetention.RUNTIME)
@Repeatable
@MustBeDocumented
annotation class Run


@Run
class SwordTest {

    @TestCase(id = "1")
    fun testCase(testId: String) {
        println("Run SwordTest ID = ${testId}")
    }

}


fun main(args: Array<String>) {
//    testAnno()
    testAnnoProcessing()
}

fun testAnnoProcessing() {
    val sword = SwordTest()
    val kClasss: KClass<out SwordTest> = sword::class
    val kClass = sword::class

    val declaredFunctions = kClass.declaredFunctions // 获取sword对象类型所声明的所有函数
    println(declaredFunctions)

    for (f in declaredFunctions) {
        // 处理 TestCase 注解，使用其中的元数据
        f.annotations.forEach {
            if (it is TestCase) {
                val id = it.id
                doSomething(id) // 注解处理逻辑
                f.call(sword, id) // 等价于 f.javaMethod?.invoke(sword, id)
                // f.javaMethod?.invoke(sword, id)
            }
        }
    }
}

private fun doSomething(id: String) {
    println("Do Something in Annotation Processing ${id} ${Date()} ")
}

fun testAnno() {
    val sword = SwordTest()
    sword::class.annotations.forEach {
        println(it)
    }

    val declaredFunctions = sword::class.declaredFunctions // 获取note对象类型所声明的所有函数
    println(declaredFunctions)

    declaredFunctions.forEach {
        // 处理 TestCase 注解，使用其中的元数据
        it.annotations.forEach {
            if (it is TestCase) {
                val id = it.id
                println("id = $id")

                val qualifiedName = it.annotationClass.qualifiedName // TestCase注解的全路径限定名
                println("qualifiedName = $qualifiedName")

                val simpleName = it.annotationClass.simpleName // TestCase注解的简单类名
                println("simpleName = $simpleName")
            }
        }

        println("成员函数: ${it.name}")
        it.parameters.forEach {
            println("函数入参: ${it.name}")
        }


    }
}

annotation class AnnoX(val value: String)

annotation class AnnoY(
    val message: String,
    val annoX: AnnoX = AnnoX("X"))





