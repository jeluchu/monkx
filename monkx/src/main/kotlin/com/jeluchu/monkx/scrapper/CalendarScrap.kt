package com.jeluchu.monkx.scrapper

import com.jeluchu.monkx.core.extensions.getSrcAttr
import com.jeluchu.monkx.core.utils.CalendarStructure
import com.jeluchu.monkx.models.calendar.AnimeCalendar
import com.jeluchu.monkx.models.calendar.WeekCalendar
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.util.Locale

/**
 * Extract the information from the following website
 * @see <a href="https://monoschinos2.com/calendario"></a>
 *
 */
fun String.extractCalendar(): WeekCalendar {
    val document: Document = Jsoup.parse(this)

    val days = listOf("lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo")
    return WeekCalendar().apply {
        days.forEachIndexed { index, day ->
            val series = document.select("div#${day}-tap-pane ul li")
            val animes = mutableListOf<AnimeCalendar>().apply {
                for (anime in series) {
                    add(
                        AnimeCalendar(
                            title = anime.select(CalendarStructure.TITLE).text(),
                            image = anime.select(CalendarStructure.IMAGE).getSrcAttr(),
                            link = anime.select(CalendarStructure.URL).attr(CalendarStructure.URL_ATTR),
                            episodeNumber = anime.select(CalendarStructure.EPISODE_NUMBER).text().removeRange(0..9).toIntOrNull() ?: 1
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