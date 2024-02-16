package com.jeluchu.monkx.models.broadcast

import com.jeluchu.monkx.core.utils.empty

/**
 * Broadcast data class.
 */
data class Broadcast(
    /**
     * Name for anime.
     */
    val title: String = String.empty(),

    /**
     * Link of anime.
     */
    val url: String = String.empty(),

    /**
     * Image for anime.
     */
    val image: String = String.empty(),

    /**
     * Id for anime.
     */
    val id: String = String.empty(),
)
