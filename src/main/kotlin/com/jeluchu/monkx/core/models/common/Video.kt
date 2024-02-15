package com.jeluchu.monkx.core.models.common

import okhttp3.Headers

/**
 * The instance that contains the data needed to watch a video.
 */
@Suppress("unused_parameter")
data class Video(val url: String,
                 val quality: String,
                 var videoUrl: String?,
                 val headers: Headers? = null,
                 val subtitleTracks: List<Track> = emptyList(),
                 val audioTracks: List<Track> = emptyList()
) {
    constructor(url: String,
                quality: String,
                videoUrl: String?,
                uri: String? = null,
                headers: Headers? = null) : this(url, quality, videoUrl, headers)
}
