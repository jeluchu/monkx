package com.jeluchu.monkx

import com.jeluchu.monkx.models.anime.AnimeEpisode
import com.jeluchu.monkx.models.anime.AnimeInfo
import com.jeluchu.monkx.models.search.AnimeSearch
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class SearchTests {
    @Test
    fun `on searchAnime anime with correct ID`() {

        val expected = listOf(
            AnimeSearch(
                title = "Shigatsu wa Kimi no Uso",
                image = "https://monoschinos2.com/thumbs/imagen/shigatsu-wa-kimi-no-uso-1662154659.jpg?v=1.5",
                year = "2014",
                type = "Anime"
            ),
            AnimeSearch(
                title = "Shigatsu wa Kimi no Uso (Your Lie in April) Castellano",
                image = "https://monoschinos2.com/thumbs/imagen/shigatsu-wa-kimi-no-uso-your-lie-in-april-castellano.jpg?v=1.5",
                year = "2014",
                type = "Anime"
            )
        )

        val result = runBlocking { Monkx.getSearchAnime("Shigatsu wa kimi no uso") }

        assertEquals(expected, result)

        runBlocking { delay(3000) }
    }

    companion object {
        @BeforeAll
        @JvmStatic
        internal fun setup() {
            Monkx
        }
    }
}