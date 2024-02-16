package com.jeluchu.monkx.scrapper

import com.jeluchu.monkx.models.calendar.AnimeCalendar
import com.jeluchu.monkx.models.calendar.WeekCalendar
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

/**
 * Extract the information from the following website
 * @see <a href="https://monoschinos2.com/calendario"></a>
 *
 */
fun String.extractCalendar(): WeekCalendar {
    val document: Document = Jsoup.parse(this)

    val days = document.select("div.accordionItem") // Selecciona todas las secciones de días

    return WeekCalendar().apply {
        days.forEachIndexed { index, day ->
            val series = day.select("div.row div.series")
            val animes = mutableListOf<AnimeCalendar>().apply {
                for (serie in series) {
                    val title = serie.select("h3").text()
                    val number = serie.select("h4").text()
                    val image = serie.select("div.seriesimg a img").attr("data-src")
                    val genres = serie.select("div.seriesbtns a").eachText()
                    add(
                        AnimeCalendar(
                            title = title,
                            image = image,
                            genres = genres,
                            episodeNumber = extractEpisodeNumber(number),
                        )
                    )
                }
            }

            when(index) {
                0 -> monday = animes
                1 -> tuesday = animes
                2 -> wednesday = animes
                3 -> thursday = animes
                4 -> friday = animes
                5 -> saturday = animes
                6 -> sunday = animes
            }
        }
    }
}

fun extractEpisodeNumber(text: String): Int {
    val regex = Regex("\\bCapitulo (\\d+)\\b")
    val matchResult = regex.find(text)
    return matchResult?.groupValues?.get(1)?.toInt() ?: 0
}