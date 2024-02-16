package com.jeluchu.monkx.models.search

/**
 * AnimeSearch data class.
 */
data class AnimeSearch(
    /**
     * Name for anime.
     */
    val title: String,

    /**
     * Image for anime.
     */
    val image: String,

    /**
     * Type for video (Anime, Movie, etc).
     */
    val type: String,

    /**
     * Year for anime.
     */
    val year: String
)