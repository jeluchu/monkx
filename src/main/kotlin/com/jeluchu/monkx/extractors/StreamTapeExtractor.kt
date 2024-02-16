package com.jeluchu.monkx.extractors

import com.jeluchu.monkx.models.servers.Server
import org.jsoup.Jsoup

class StreamTapeExtractor() {
    private fun videoFromUrl(url: String): Server? {
        val baseUrl = "https://streamtape.com/e/"
        val newUrl = if (!url.startsWith(baseUrl)) {
            val id = url.split("/").getOrNull(4) ?: return null
            baseUrl + id
        } else { url }

        val document = Jsoup.connect(newUrl).get()
        val targetLine = "document.getElementById('robotlink')"
        val script = document.selectFirst("script:containsData($targetLine)")
            ?.data()
            ?.substringAfter("$targetLine.innerHTML = '")
            ?: return null
        val videoUrl = "https:" + script.substringBefore("'") +
            script.substringAfter("+ ('xcd").substringBefore("'")

        return if (videoUrl.isNotEmpty()) Server(id = "streamtape", url = videoUrl)
        else Server()
    }

    fun videosFromUrl(url: String) = videoFromUrl(url)?.let(::listOf).orEmpty()
}
