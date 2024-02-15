package com.jeluchu.monkx.core.utils

import okhttp3.Headers
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import okhttp3.internal.EMPTY_BYTE_ARRAY
import org.jsoup.nodes.Document

val commonEmptyHeaders: Headers = Headers.headersOf()
val commonEmptyRequestBody: RequestBody = EMPTY_BYTE_ARRAY.toRequestBody()
val commonEmptyResponse: ResponseBody = EMPTY_BYTE_ARRAY.toResponseBody()

fun extractValue(document: Document, label: String): String? {
    val row = document.select("div.chapterdetls2 table tbody tr:has(td.table1:contains($label))")

    if (row.size == 1) {
        return row.first()?.select("td:eq(1)")?.text().orEmpty()
    }

    return null
}

fun Headers.toMap(): Map<String, String> {
    val headersMap = mutableMapOf<String, String>()

    for (i in 0 until size) {
        val name = name(i)
        val value = value(i)
        headersMap[name] = value
    }

    return headersMap
}
