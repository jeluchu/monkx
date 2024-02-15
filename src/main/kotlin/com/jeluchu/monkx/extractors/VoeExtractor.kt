package com.jeluchu.monkx.extractors

import com.jeluchu.monkx.core.models.common.Video
import com.jeluchu.monkx.core.utils.PlaylistUtils
import com.jeluchu.monkx.models.servers.Server
import kotlinx.serialization.Serializable
import okhttp3.OkHttpClient
import org.jsoup.Jsoup
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

@OptIn(ExperimentalEncodingApi::class)
class VoeExtractor {
    private val playlistUtils by lazy { PlaylistUtils() }

    @Serializable
    data class VideoLinkDTO(val file: String)

    fun videosFromUrl(url: String, prefix: String = ""): List<Server> {
        val document = Jsoup.connect(url).get()
        val script = document.selectFirst("script:containsData(const sources), script:containsData(var sources), script:containsData(wc0)")
            ?.data()
            ?: return emptyList()
        val playlistUrl = when {
            // Layout 1
            script.contains("sources") -> {
                script.substringAfter("hls': '").substringBefore("'")
            }
            // Layout 2
            script.contains("wc0") -> {
                val base64 = Regex("'.*'").find(script)!!.value
                val decoded = Base64.decode(base64).let(::String)
                ""
                //json.decodeFromString<VideoLinkDTO>(decoded).file
            }
            else -> return emptyList()
        }

        playlistUtils.extractFromHls(playlistUrl,
            videoNameGen = { quality -> "${prefix}Voe: $quality" }
        )

        return listOf(Server())
    }
}
