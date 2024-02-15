package com.jeluchu.monkx.extractors

import com.jeluchu.monkx.models.servers.Server
import org.jsoup.Jsoup

class OkruExtractor {
    fun videosFromUrl(url: String): Server {
        var finalLink = ""

        if (!url.contains("m.ok.ru")) {
            finalLink = url
                .replace("ok.ru", "m.ok.ru")
                .replace("videoembed", "video")
        }

        val doc = Jsoup.connect(finalLink).get()
        doc.select("div.mvplayer_cont").select("a").first()?.let { element ->
            return Server(id = "okru", url = element.attr("href"))
        }

        return Server()
    }
}
