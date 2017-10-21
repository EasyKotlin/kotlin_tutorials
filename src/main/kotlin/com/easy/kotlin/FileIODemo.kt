package com.easy.kotlin

import java.io.File
import java.net.URL
import java.nio.charset.Charset

fun getUrlContent(url: String): String {
    return URL(url).readText(Charset.defaultCharset())
}

fun getUrlBytes(url: String): ByteArray {
    return URL(url).readBytes()
}

fun writeUrlBytesTo(filename: String, url: String) {
    val bytes = URL(url).readBytes()
    File(filename).writeBytes(bytes)
}
