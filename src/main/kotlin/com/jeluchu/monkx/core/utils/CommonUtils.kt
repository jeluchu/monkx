package com.jeluchu.monkx.core.utils

import okhttp3.Headers
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import okhttp3.internal.EMPTY_BYTE_ARRAY

val commonEmptyHeaders: Headers = Headers.headersOf()
val commonEmptyRequestBody: RequestBody = EMPTY_BYTE_ARRAY.toRequestBody()
val commonEmptyResponse: ResponseBody = EMPTY_BYTE_ARRAY.toResponseBody()

fun Int.Companion.zero() = 0
fun String.Companion.empty() = ""
fun String.toIdFromView() = replace("https://monoschinos2.com/ver/", "")
fun String.toIdFromAnime() = replace("https://monoschinos2.com/anime/", "")

fun Headers.toMap(): Map<String, String> {
    val headersMap = mutableMapOf<String, String>()

    for (i in 0 until size) {
        val name = name(i)
        val value = value(i)
        headersMap[name] = value
    }

    return headersMap
}
