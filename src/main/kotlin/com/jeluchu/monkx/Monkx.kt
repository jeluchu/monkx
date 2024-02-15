package com.jeluchu.monkx

import com.jeluchu.monkx.core.connection.RestClient
import com.jeluchu.monkx.core.utils.extractValue
import com.jeluchu.monkx.models.anime.AnimeEpisode
import com.jeluchu.monkx.models.anime.AnimeInfo
import com.jeluchu.monkx.models.search.AnimeSearch
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

object Monkx {
    private var restClient = RestClient()

    /**
     * Function to get all anime returned after a search.
     * @return List of anime that have a similar title to the one in the query
     * @see AnimeSearch
     */
    suspend fun getSearchAnime(anime: String): List<AnimeSearch> {
        val animes = mutableListOf<AnimeSearch>()
        val html = restClient.request("buscar?q=${anime.replace(" ", "+")}")
        val document: Document = Jsoup.parse(html)
        val results = document.select(".heromain .series")

        for (result in results) {
            val info = result.select(".seriesinfo").text().orEmpty().split(" · ")
            val title = result.select(".seristitles").text().orEmpty()
            val image = result.select(".animemainimg").attr("src").orEmpty()

            animes.add(
                AnimeSearch(
                    title = title,
                    image = image,
                    type = info[0],
                    year = if (info.size < 2) "" else info[1]
                )
            )
        }

        return animes
    }

    /**
     * Function to get all information of anime.
     * @return Anime information
     * @see AnimeInfo
     */
    suspend fun getAnime(anime: String): AnimeInfo {
        val html = restClient.request("anime/${anime}")
        val document: Document = Jsoup.parse(html)
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
}