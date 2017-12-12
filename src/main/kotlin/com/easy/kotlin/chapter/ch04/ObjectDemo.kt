package com.easy.kotlin

object StringUtilKt {
    fun isEmpty(str: String): Boolean {
        return str.trim() == ""
    }
}

fun main(args: Array<String>) {
    val b = StringUtilKt.isEmpty("")
    println(b)

    val p = DataProcessor()
    p.processHTML()
    p.processJSON()
//    p.processText()
    DataProcessor.processText()

}


class DataProcessor {
    fun processJSON() {
        println("Process JSON")
    }

    fun processHTML() {
        println("Process HTML")
    }

    companion object { // 伴生对象
        fun processText() {
            println("Process Text")
        }
    }

}
