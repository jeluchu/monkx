package com.jeluchu.monkx.scrapper

import android.content.Context
import com.ead.lib.monoschinos.core.chapterRequester
import com.ead.lib.monoschinos.core.regexRequested
import com.ead.lib.monoschinos.core.system.extensions.toEpisodeList
import com.jeluchu.monkx.core.utils.AnimeDetailStructure
import com.jeluchu.monkx.legacy.util.Scrapper
import com.jeluchu.monkx.models.anime.AnimeEpisode
import com.jeluchu.monkx.models.anime.AnimeInfo
import org.json.JSONArray
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

/**
 * Extract the information from the following website
 * @see <a href="https://monoschinos2.com/anime/shigatsu-wa-kimi-no-uso-sub-espanol"></a>
 *
 * shigatsu-wa-kimi-no-uso-sub-espanol is the example
 *
 */
suspend fun String.extractAnime(context: Context, id: String): AnimeInfo {
    Scrapper.initialize(context)
    val document: Document = Jsoup.parse(this)
    val title = document.select(AnimeDetailStructure.TITLE).text().orEmpty()
    val state = document.select(AnimeDetailStructure.STATUS).text().orEmpty()
    val release = document.select(AnimeDetailStructure.RELEASE).text().orEmpty()
    val genres = document.select(AnimeDetailStructure.GENRES).map { element -> element.text() }
    val image = document.select(AnimeDetailStructure.PROFILE_IMAGE).attr("src").orEmpty()
    val cover = document.select(AnimeDetailStructure.COVER_IMAGE).first()?.attr("src").orEmpty()
    val synopsis = document.select(AnimeDetailStructure.SYNOPSIS).text().replace(" Ver menos", "")

    val  data = Scrapper.evaluate(Properties.HOME_PAGE + Properties.ANIME_QUERY + id, code = chapterRequester, regex = regexRequested)
    val episodes = JSONArray(data).toEpisodeList().map { episode ->
        AnimeEpisode(
            number = episode.number,
            id = episode.seo,
        )
    }

    return AnimeInfo(
        title = title,
        image = image,
        cover = cover,
        synopsis = synopsis,
        state = state,
        release = release,
        genres = genres,
        episodesCount = episodes.count(),
        episodes = episodes
    )
}