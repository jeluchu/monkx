package com.jeluchu.monkx

import android.content.Context
import com.jeluchu.monkx.core.connection.RestClient
import com.jeluchu.monkx.models.anime.AnimeInfo
import com.jeluchu.monkx.models.calendar.WeekCalendar
import com.jeluchu.monkx.models.episodes.Episode
import com.jeluchu.monkx.models.search.AnimeSearch
import com.jeluchu.monkx.models.servers.Server
import com.jeluchu.monkx.scrapper.extractAnime
import com.jeluchu.monkx.scrapper.extractCalendar
import com.jeluchu.monkx.scrapper.extractEpisodes
import com.jeluchu.monkx.scrapper.extractSearch
import com.jeluchu.monkx.scrapper.extractServers

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
    suspend fun getAnime(context: Context, id: String): AnimeInfo =
        restClient.request("anime/${id}").extractAnime(context, id)

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
}