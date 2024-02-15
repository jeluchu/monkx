package com.jeluchu.monkx

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class ServersTests {
    @Test
    fun `on getAnime pass a query and return anime info`() {

        val result = runBlocking { Monkx.getServers("yuuki-bakuhatsu-bang-bravern-episodio-6") }

        result
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