package com.jeluchu.monkx

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import com.jeluchu.monkx.models.anime.AnimeEpisode
import com.jeluchu.monkx.models.anime.AnimeInfo
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class AnimeTests {

    private lateinit var context: Context

    @BeforeEach
    fun setup() {
        context = InstrumentationRegistry.getInstrumentation().context
    }

    @Test
    fun `on getAnime pass a query and return anime info`() {
        val anime = AnimeInfo(
            title = "Shigatsu wa Kimi no Uso",
            image = "https://monoschinos2.com/thumbs/imagen/shigatsu-wa-kimi-no-uso-1662154659.jpg?v=1.5",
            cover = "https://monoschinos2.com/assets/img/serie/portada/shigatsu-wa-kimi-no-uso.jpg",
            synopsis = "Arima Kousei era un famoso y prodigioso pianista a su corta edad debido a las prácticas diarias de piano que realizaba con su madre para complacer el deseo de esta el cual era convertirlo en lo que ella jamás pudo ser, una reconocida pianista que recorriera la china de Mao",
            state = "Finalizado",
            release = "Anime",
            genres= listOf(
                "Drama",
                "Escolares",
                "Música"
            ),
            episodesCount = 23,
            episodes = listOf(
                AnimeEpisode(id="shigatsu-wa-kimi-no-uso-episodio-1", number = 1),
                AnimeEpisode(id="shigatsu-wa-kimi-no-uso-episodio-2", number = 2),
                AnimeEpisode(id="shigatsu-wa-kimi-no-uso-episodio-3", number = 3),
                AnimeEpisode(id="shigatsu-wa-kimi-no-uso-episodio-4", number = 4),
                AnimeEpisode(id="shigatsu-wa-kimi-no-uso-episodio-5", number = 5),
                AnimeEpisode(id="shigatsu-wa-kimi-no-uso-episodio-6", number = 6),
                AnimeEpisode(id="shigatsu-wa-kimi-no-uso-episodio-7", number = 7),
                AnimeEpisode(id="shigatsu-wa-kimi-no-uso-episodio-8", number = 8),
                AnimeEpisode(id="shigatsu-wa-kimi-no-uso-episodio-9", number = 9),
                AnimeEpisode(id="shigatsu-wa-kimi-no-uso-episodio-10", number = 10),
                AnimeEpisode(id="shigatsu-wa-kimi-no-uso-episodio-11", number = 11),
                AnimeEpisode(id="shigatsu-wa-kimi-no-uso-episodio-12", number = 12),
                AnimeEpisode(id="shigatsu-wa-kimi-no-uso-episodio-13", number = 13),
                AnimeEpisode(id="shigatsu-wa-kimi-no-uso-episodio-14", number = 14),
                AnimeEpisode(id="shigatsu-wa-kimi-no-uso-episodio-15", number = 15),
                AnimeEpisode(id="shigatsu-wa-kimi-no-uso-episodio-16", number = 16),
                AnimeEpisode(id="shigatsu-wa-kimi-no-uso-episodio-17", number = 17),
                AnimeEpisode(id="shigatsu-wa-kimi-no-uso-episodio-18", number = 18),
                AnimeEpisode(id="shigatsu-wa-kimi-no-uso-episodio-19", number = 19),
                AnimeEpisode(id="shigatsu-wa-kimi-no-uso-episodio-20", number = 20),
                AnimeEpisode(id="shigatsu-wa-kimi-no-uso-episodio-21", number = 21),
                AnimeEpisode(id="shigatsu-wa-kimi-no-uso-episodio-22", number = 22),
                AnimeEpisode(id="shigatsu-wa-kimi-no-uso-episodio-23", number = 23)
            )
        )

        val result = runBlocking { Monkx.getAnime(context, "shigatsu-wa-kimi-no-uso-sub-espanol") }

        assertEquals(anime.release, result.release)
        assertEquals(anime.title, result.title)
        assertEquals(anime.state, result.state)
        assertEquals(anime.genres, result.genres)

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