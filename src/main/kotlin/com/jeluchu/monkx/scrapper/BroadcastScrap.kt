package com.jeluchu.monkx.scrapper

import com.jeluchu.monkx.core.utils.toIdFromAnime
import com.jeluchu.monkx.models.broadcast.Broadcast
import org.jsoup.nodes.Document

/**
 * Extract the information from the following website
 * @see <a href="https://monoschinos2.com/emision"></a>
 *
 */
fun Document.extractBroadcast(): MutableList<Broadcast> {
    val animes = select("div.row div.col-md-4.col-lg-2.col-6 a[title]")
    return mutableListOf<Broadcast>().apply {
        animes.forEach { anime ->
            val title = anime.attr("title")
            val url = anime.attr("href")
            val imageUrl = anime.select("div.seriesimg img")
            val image = imageUrl.attr("data-src")

            add(
                Broadcast(
                    url = url,
                    title = title,
                    image = image,
                    id = url.toIdFromAnime()
                )
            )
        }
    }
}