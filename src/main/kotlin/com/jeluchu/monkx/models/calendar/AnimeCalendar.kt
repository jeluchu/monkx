package com.jeluchu.monkx.models.calendar

/**
 * AnimeCalendar data class.
 */
data class AnimeCalendar(
    /**
     * Name for anime.
     */
    val title: String = "",

    /**
     * Number of episode.
     */
    val episodeNumber: Int = 0,

    /**
     * Image for anime.
     */
    val image: String = "",

    /**
     * List of genres.
     */
    val genres: List<String> = emptyList()
)
