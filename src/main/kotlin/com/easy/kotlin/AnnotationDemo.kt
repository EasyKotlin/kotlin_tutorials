package com.easy.kotlin

annotation class Suspendable

val fu = @Suspendable { println(1) }

fun main(args: Array<String>) {
    fu.invoke()

    fu.javaClass.declaredAnnotations.forEach {
        val name = it.annotationClass.qualifiedName
        println(name)
    }
}