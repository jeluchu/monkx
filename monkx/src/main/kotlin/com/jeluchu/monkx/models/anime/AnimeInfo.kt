package com.jeluchu.monkx.models.anime

import com.jeluchu.monkx.core.utils.empty
import com.jeluchu.monkx.core.utils.zero

/**
 * AnimeInfo data class.
 */
data class AnimeInfo(
    /**
     * Title for anime.
     */
    val title: String = String.empty(),

    /**
     * Image for anime.
     */
    val image: String = String.empty(),

    /**
     * Cover image for anime.
     */
    val cover: String = String.empty(),

    /**
     * Synopsis for anime.
     */
    val synopsis: String = String.empty(),

    /**
     * State for anime.
     */
    val state: String = String.empty(),

    /**
     * Type of anime.
     */
    val release: String = String.empty(),

    /**
     * Genres for anime.
     */
    val genres: List<String> = emptyList(),

    /**
     * Episodes count for anime.
     */
    val episodesCount: Int = Int.zero(),

    /**
     * Episodes for anime.
     */
    val episodes: List<AnimeEpisode> = emptyList(),
)