package com.jeluchu.monkx.extractors

import com.jeluchu.monkx.core.models.common.Track
import com.jeluchu.monkx.core.models.common.Video
import org.jsoup.Jsoup

class StreamTapeExtractor() {
    fun videoFromUrl(url: String, quality: String = "StreamTape", subtitleList: List<Track> = emptyList()): Video? {
        val baseUrl = "https://streamtape.com/e/"
        val newUrl = if (!url.startsWith(baseUrl)) {
            // ["https", "", "<domain>", "<???>", "<id>", ...]
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

        return Video(videoUrl, quality, videoUrl, subtitleTracks = subtitleList)
    }

    fun videosFromUrl(url: String, quality: String = "StreamTape", subtitleList: List<Track> = emptyList()): List<Video> {
        return videoFromUrl(url, quality, subtitleList)?.let(::listOf).orEmpty()
    }
}
