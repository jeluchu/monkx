package com.jeluchu.monkx

import com.jeluchu.monkx.core.connection.RestClient
import com.jeluchu.monkx.models.anime.AnimeInfo
import com.jeluchu.monkx.models.broadcast.Broadcast
import com.jeluchu.monkx.models.calendar.WeekCalendar
import com.jeluchu.monkx.models.episodes.Episode
import com.jeluchu.monkx.models.search.AnimeSearch
import com.jeluchu.monkx.models.servers.Server
import com.jeluchu.monkx.scrapper.extractAnime
import com.jeluchu.monkx.scrapper.extractBroadcast
import com.jeluchu.monkx.scrapper.extractCalendar
import com.jeluchu.monkx.scrapper.extractEpisodes
import com.jeluchu.monkx.scrapper.extractSearch
import com.jeluchu.monkx.scrapper.extractServers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

object Monkx {
    private var restClient = RestClient()

    /**
     * Function to get all anime returned after a search.
     * @return List of anime that have a similar title to the one in the query
     * @see AnimeSearch
     */
    suspend fun getSearchAnime(anime: String): List<AnimeSearch> =
        restClient.request("buscar?q=${anime.replace(" ", "+")}").extractSearch()

    /**
     * Function to get all information of anime.
     * @return Anime information
     * @see AnimeInfo
     */
    suspend fun getAnime(anime: String): AnimeInfo =
        restClient.request("anime/${anime}").extractAnime()

    /**
     * Function to get links of servers for anime episodes.
     * @return List of servers
     * @see Server
     */
    suspend fun getServers(id: String): List<Server> =
        restClient.request("ver/${id}").extractServers()

    /**
     * Function to get the latest uploaded episodes.
     * @return List of episodes
     * @see Episode
     */
    suspend fun getLastEpisodes(): List<Episode> =
        restClient.request().extractEpisodes()

    /**
     * Function to get animes in the week.
     * @return List of animes
     * @see WeekCalendar
     */
    suspend fun getCalendar(): WeekCalendar =
        restClient.request("calendario").extractCalendar()


    /**
     * Function to get the anime that are currently on air.
     * @return Links of animes
     * @see Broadcast
     */
    suspend fun getBroadcast(): List<Broadcast> {
        val firstPage = restClient.request("emision")
        val document: Document = Jsoup.parse(firstPage)
        val paginationElements = document.select("div.pagination ul.pagination li.page-item:not(.disabled) a.page-link")

        return document.extractBroadcast().apply {
            for (page in 2..paginationElements.size) {
                val reqPage = restClient.request("emision?p=$page")
                addAll(Jsoup.parse(reqPage).extractBroadcast())
                runBlocking { delay(3000) }
            }
        }
    }
}