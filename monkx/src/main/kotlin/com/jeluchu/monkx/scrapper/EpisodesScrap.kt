package com.jeluchu.monkx.scrapper

import com.jeluchu.monkx.core.utils.LastEpisodesStructure
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

    return document.select(LastEpisodesStructure.CLASS_LIST).map { episode ->
        val link = episode.select(LastEpisodesStructure.URL).attr("href")
        Episode(
            url = link,
            id = link.toIdFromView(),
            type = episode.select(LastEpisodesStructure.TYPE).text(),
            title = episode.select(LastEpisodesStructure.TITLE).text(),
            image = episode.select(LastEpisodesStructure.IMAGE).attr("data-src"),
            episodeNumber = episode.select(LastEpisodesStructure.NUMBER).text().toIntOrNull() ?: 1
        )
    }
}