package com.jeluchu.monkx.models.anime

import com.jeluchu.monkx.core.utils.empty
import com.jeluchu.monkx.core.utils.zero

/**
 * AnimeEpisode data class.
 */
open class AnimeEpisode(
    /**
     * Id for episode.
     */
    val id: String = String.empty(),

    /**
     * Episode number.
     */
    val number: Int = Int.zero()
)