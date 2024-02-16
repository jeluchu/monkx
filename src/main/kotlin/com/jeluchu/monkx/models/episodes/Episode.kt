package com.jeluchu.monkx.models.episodes

/**
 * Episode data class.
 */
data class Episode(
    /**
     * Name for anime.
     */
    val title: String,

    /**
     * Number of episode.
     */
    val episodeNumber: Int,

    /**
     * Type for video (Anime, Movie, etc).
     */
    val type: String,

    /**
     * Image for anime.
     */
    val image: String,

    /**
     * url of episode.
     */
    val url: String,

    /**
     * Id of episode.
     */
    val id: String
)