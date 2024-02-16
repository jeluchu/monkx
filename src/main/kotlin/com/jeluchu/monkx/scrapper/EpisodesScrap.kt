package com.jeluchu.monkx.scrapper

import com.jeluchu.monkx.core.utils.toIdFromView
import com.jeluchu.monkx.models.episodes.Episode
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

/**
 * Extract the information from the following website
 * @see <a href="https://monoschinos2.com/"></a>
 *
 */
fun String.extractEpisodes(): List<Episode> {
    val document: Document = Jsoup.parse(this)
    val episodeElements: List<Element> = document.select("div.row.row-cols-5 > div.col")

    return episodeElements.map { episodeElement ->
        val title = episodeElement.select("h2.animetitles").text()
        val episodeNumber = episodeElement.select("div.hoverdiv div.positioning p").text().toIntOrNull() ?: 0
        val type = episodeElement.select("div.animes button").text()
        val imageUrl = episodeElement.select("div.animes img").attr("data-src")
        val url = episodeElement.select("a").attr("href")

        Episode(
            id = url.toIdFromView(),
            title = title,
            episodeNumber = episodeNumber,
            type = type,
            image = imageUrl,
            url = url
        )
    }
}