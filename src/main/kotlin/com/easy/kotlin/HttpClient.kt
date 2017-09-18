package com.easy.kotlin

import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit


fun main(args: Array<String>) {
    val hasRunningInstanceApi = "http://h5agent.alibaba.net/hasRunningInstance"
    val runApi = "http://h5agent.alibaba.net/run?timestamp=2000000000000&url=http://www.baidu.com"
    val runApiIP = "http://h5agent.alibaba.net/run?timestamp=2000000000000&url=http://www.baidu.com"
//    getAsync(hasRunningInstanceApi)
//    getAsync(runApi)
//    getAsync(runApiIP)
    get(hasRunningInstanceApi)
//    get(runApi)
//    get(runApiIP)
}

fun get(url: String): String? {
    var result: String? = ""
    val okhttp = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.MINUTES)
            .readTimeout(10, TimeUnit.MINUTES)
            .writeTimeout(10, TimeUnit.MINUTES)
            .build()

    val request = Request.Builder()
            .url(url)
            .addHeader("Connection", "close")
            .build()

    val call = okhttp.newCall(request)

    try {
        val response = call.execute()
        result = response.body()?.string()
        println(result)

    } catch (e: IOException) {
        e.printStackTrace()
    }

    return result
}


fun getAsync(url: String) {
    val okhttp = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.MINUTES)
            .readTimeout(10, TimeUnit.MINUTES)
            .writeTimeout(10, TimeUnit.MINUTES)
            .build()

    val request = Request.Builder()
            .url(url)
            .build()

    val call = okhttp.newCall(request)

    call.enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            println(e.message)
            e.printStackTrace()
        }

        override fun onResponse(call: Call, response: Response) {
            try {
                val result = response.body()?.string()
                println(result)
            } catch (e: IOException) {
                println("response = ${response}")
                e.printStackTrace()
            }
        }
    })

}
