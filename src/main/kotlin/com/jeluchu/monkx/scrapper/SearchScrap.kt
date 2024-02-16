package com.jeluchu.monkx.scrapper

import com.jeluchu.monkx.core.utils.toIdFromAnime
import com.jeluchu.monkx.models.search.AnimeSearch
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

/**
 * Extract the information from the following website
 * @see <a href="https://monoschinos2.com/buscar?q=Shigatsu+wa+kimi+no+uso"></a>
 *
 * Shigatsu+wa+kimi+no+uso  is the example
 *
 */
fun String.extractSearch(): List<AnimeSearch> {
    val document: Document = Jsoup.parse(this)
    return mutableListOf<AnimeSearch>().apply {
        val results = document.select(".heromain .series")
        results.forEachIndexed { index, result ->
            val info = result.select(".seriesinfo").text().orEmpty().split(" · ")
            val title = result.select(".seristitles").text().orEmpty()
            val link = document.select(".heromain a[href]")[0].attr("href").orEmpty()
            val image = result.select(".animemainimg").attr("src").orEmpty()
            add(
                AnimeSearch(
                    title = title,
                    image = image,
                    type = info[0],
                    link = link,
                    id = link.toIdFromAnime(),
                    year = if (info.size < 2) "" else info[1]
                )
            )
        }
    }
}