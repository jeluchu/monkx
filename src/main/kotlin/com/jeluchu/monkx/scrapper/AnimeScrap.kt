package com.jeluchu.monkx.scrapper

import com.jeluchu.monkx.models.anime.AnimeEpisode
import com.jeluchu.monkx.models.anime.AnimeInfo
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

/**
 * Extract the information from the following website
 * @see <a href="https://monoschinos2.com/anime/shigatsu-wa-kimi-no-uso-sub-espanol"></a>
 *
 * shigatsu-wa-kimi-no-uso-sub-espanol is the example
 *
 */
fun String.extractAnime(): AnimeInfo {
    val document: Document = Jsoup.parse(this)
    val result = document.select(".heromain")
    val title = result.select("div.chapterdetails h1").text().orEmpty()
    val image = result.select("div.chapterpic img[src]").attr("src").orEmpty()
    val cover = result.select("div.herobg img[src]").first()?.attr("src").orEmpty()
    val synopsis = result.select("div.chapterdetails p.textComplete").text().replace(" Ver menos", "")
    val state = extractValue(document, "Estado").orEmpty()
    val type = extractValue(document, "Tipo").orEmpty()

    val genres = mutableListOf<String>()
    result.select("div.chapterdetls2 td a").forEach { genres.add(it.text()) }

    val episodes = mutableListOf<AnimeEpisode>()
    document.select(".allanimes .col-item").forEachIndexed { index, episode ->
        episodes.add(
            AnimeEpisode(
                number = index + 1,
                id = episode.select("a").attr("href").replace("https://monoschinos2.com/ver/", ""),
            )
        )
    }

    return AnimeInfo(
        title = title,
        image = image,
        cover = cover,
        synopsis = synopsis,
        state = state,
        type = type,
        genres = genres,
        episodesCount = episodes.count(),
        episodes = episodes
    )
}

private fun extractValue(document: Document, label: String): String? {
    val row = document.select("div.chapterdetls2 table tbody tr:has(td.table1:contains($label))")
    if (row.size == 1) return row.first()?.select("td:eq(1)")?.text().orEmpty()
    return null
}