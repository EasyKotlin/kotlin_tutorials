package com.easy.kotlin

annotation class Suspendable

val f = @Suspendable { println(1) }

fun main(args: Array<String>) {
    f.invoke()

    f.javaClass.declaredAnnotations.forEach {
        val name = it.annotationClass.qualifiedName
        println(name)
    }
}