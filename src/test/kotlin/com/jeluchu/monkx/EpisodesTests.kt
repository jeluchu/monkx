package com.jeluchu.monkx

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class EpisodesTests {
    @Test
    fun `on getLastEpisodes and return list of episodes`() {
        val result = runBlocking { Monkx.getLastEpisodes() }
        assertEquals(30, result.size)
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