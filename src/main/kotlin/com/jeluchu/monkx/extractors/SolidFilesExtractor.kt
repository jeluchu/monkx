package com.jeluchu.monkx.extractors

import com.jeluchu.monkx.core.models.common.Video
import org.jsoup.Jsoup

class SolidFilesExtractor {
    fun videosFromUrl(url: String, prefix: String = ""): List<Video> {
        val videoList = mutableListOf<Video>()
        return try {
            val document = Jsoup.connect(url).get()
            document.select("script").forEach { script ->
                if (script.data().contains("\"downloadUrl\":")) {
                    val data = script.data().substringAfter("\"downloadUrl\":").substringBefore(",")
                    val link = data.replace("\"", "")
                    val quality = prefix + "SolidFiles"
                    videoList.add(Video(link, quality, link))
                }
            }
            videoList
        } catch (e: Exception) {
            videoList
        }
    }
}
