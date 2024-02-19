package com.jeluchu.monkx

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class ServersTests {
    @Test
    fun `on getAnime pass a query and return anime info`() {
        val result = runBlocking { Monkx.getServers("yuuki-bakuhatsu-bang-bravern-episodio-6") }
        assertTrue(result.isNotEmpty())
        runBlocking { delay(3000) }
    }
}