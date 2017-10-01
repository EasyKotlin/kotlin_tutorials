package com.easy.kotlin

import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import java.net.URL

object HTMLParser {
    fun getElementsByAttributeValue(html: String, attribute: String, name: String): Elements {
        val document = Jsoup.parse(html)
        return document.html(html).getElementsByAttributeValue(attribute, name)
    }

    fun getElementsByClass(html: String, className: String, name: String): Elements {
        val document = Jsoup.parse(html)
        return document.html(html).getElementsByClass(className)
    }

    fun getElementsByTag(html: String, tagName: String): Elements {
        val document = Jsoup.parse(html)
        return document.html(html).getElementsByTag(tagName)
    }

    fun getElementsById(html: String, id: String): Element {
        val document = Jsoup.parse(html)
        return document.html(html).getElementById(id)
    }


}

fun main(args: Array<String>) {
    val url = URL("https://www.baidu.com/")
    val html = url.readText()

    //document.getElementsByTagName("title")[0].innerHTML
    val elements = HTMLParser.getElementsByTag(html, "title")
    elements.eachText().forEach { println(it) }

    val form = HTMLParser.getElementsById(html, "form")
    form.allElements.forEach {
        println(it.html())
    }

}
