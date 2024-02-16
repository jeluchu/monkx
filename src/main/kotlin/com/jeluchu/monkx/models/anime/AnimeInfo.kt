package com.jeluchu.monkx.models.anime

/**
 * AnimeInfo data class.
 */
data class AnimeInfo(
    /**
     * Title for anime.
     */
    val title: String,

    /**
     * Image for anime.
     */
    val image: String,

    /**
     * Cover image for anime.
     */
    val cover: String,

    /**
     * Synopsis for anime.
     */
    val synopsis: String,

    /**
     * State for anime.
     */
    val state: String,

    /**
     * Type of anime.
     */
    val type: String,

    /**
     * Genres for anime.
     */
    val genres: List<String>,

    /**
     * Episodes count for anime.
     */
    val episodesCount: Int,

    /**
     * Episodes for anime.
     */
    val episodes: List<AnimeEpisode>
)