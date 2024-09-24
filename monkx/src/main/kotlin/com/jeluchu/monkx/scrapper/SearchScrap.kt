package com.jeluchu.monkx.scrapper

import com.jeluchu.monkx.core.extensions.getSrcAttr
import com.jeluchu.monkx.core.utils.SearchStructure
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
    val animesClassList = document.select(SearchStructure.CLASS_LIST)
    val searchQueryAttr = animesClassList.firstOrNull()?.getSrcAttr(SearchStructure.IMAGE).orEmpty()

    return animesClassList.map { element ->
        val url = element.select(SearchStructure.URL).attr("href")

        AnimeSearch(
            link = url,
            id = url.toIdFromAnime(),
            type = element.select(SearchStructure.TYPE).text(),
            title = element.select(SearchStructure.TITLE).text(),
            year = element.select(SearchStructure.YEAR).text().toString(),
            image = element.select(SearchStructure.IMAGE).attr(searchQueryAttr)
        )
    }
}