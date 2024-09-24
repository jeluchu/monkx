package com.jeluchu.monkx.models.calendar

import com.jeluchu.monkx.core.utils.empty
import com.jeluchu.monkx.core.utils.zero

/**
 * AnimeCalendar data class.
 */
data class AnimeCalendar(
    /**
     * Name for anime.
     */
    val title: String = String.empty(),

    /**
     * Number of episode.
     */
    val episodeNumber: Int = Int.zero(),

    /**
     * Image for anime.
     */
    val image: String = String.empty(),

    /**
     * link for anime.
     */
    val link: String = String.empty()
)
