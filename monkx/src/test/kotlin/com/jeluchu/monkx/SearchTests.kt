package com.jeluchu.monkx

import com.jeluchu.monkx.models.search.AnimeSearch
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class SearchTests {
    @Test
    fun `on searchAnime anime with correct ID`() {

        val expected = listOf(
            AnimeSearch(
                title = "Shigatsu wa Kimi no Uso",
                image = "https://monoschinos2.com/thumbs/imagen/shigatsu-wa-kimi-no-uso-1662154659.jpg?v=1.5",
                year = "2014",
                type = "Anime",
                id = "shigatsu-wa-kimi-no-uso-sub-espanol",
                link = "https://monoschinos2.com/anime/shigatsu-wa-kimi-no-uso-sub-espanol"
            ),
            AnimeSearch(
                title = "Shigatsu wa Kimi no Uso (Your Lie in April) Castellano",
                image = "https://monoschinos2.com/thumbs/imagen/shigatsu-wa-kimi-no-uso-your-lie-in-april-castellano.jpg?v=1.5",
                year = "2014",
                type = "Anime",
                id = "shigatsu-wa-kimi-no-uso-your-lie-in-april-castellano-sub-espanol",
                link = "https://monoschinos2.com/anime/shigatsu-wa-kimi-no-uso-your-lie-in-april-castellano-sub-espanol"
            )
        )

        val result = runBlocking { Monkx.getSearchAnime("Shigatsu wa Kimi no Uso") }

        assertEquals(expected.first().title, result.first().title)
        assertEquals(expected.first().image, result.first().image)
        assertEquals(expected.first().year, result.first().year)
        assertEquals(expected.first().type, result.first().type)
        assertEquals(expected.first().id, result.first().id)
        assertEquals(expected.first().link, result.first().link)

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