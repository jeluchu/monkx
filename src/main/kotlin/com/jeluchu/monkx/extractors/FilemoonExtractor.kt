package com.jeluchu.monkx.extractors

import com.jeluchu.monkx.core.models.common.Video
import com.jeluchu.monkx.core.utils.PlaylistUtils
import com.jeluchu.monkx.core.utils.toMap
import dev.datlag.jsunpacker.JsUnpacker
import okhttp3.Headers
import okhttp3.HttpUrl.Companion.toHttpUrl
import org.jsoup.Jsoup

class FilemoonExtractor() {
    fun videosFromUrl(url: String, prefix: String = "Filemoon - ", headers: Headers? = null): List<Video> {
        return runCatching {
            val httpUrl = url.toHttpUrl()
            val videoHeaders = (headers?.newBuilder() ?: Headers.Builder())
                .set("Referer", url)
                .set("Origin", "https://${httpUrl.host}")
                .build()

            val doc = Jsoup.connect(url).headers(videoHeaders.toMap()).get()
            val jsEval = doc.selectFirst("script:containsData(eval):containsData(m3u8)")!!.data()
            val unpacked = JsUnpacker.unpackAndCombine(jsEval).orEmpty()
            val masterUrl = unpacked.takeIf(String::isNotBlank)
                ?.substringAfter("{file:\"", "")
                ?.substringBefore("\"}", "")
                ?.takeIf(String::isNotBlank)
                ?: return emptyList()

            PlaylistUtils(videoHeaders).extractFromHls(
                masterUrl,
                videoNameGen = { "$prefix$it" },
            )
        }.getOrElse { emptyList() }
    }
}
