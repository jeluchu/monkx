package com.jeluchu.monkx

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CalendarTests {
    @Test
    fun `on getAnime pass a query and return anime info`() {
        val result = runBlocking { Monkx.getCalendar() }
        assertTrue(result.monday.isNotEmpty())
        assertTrue(result.tuesday.isNotEmpty())
        assertTrue(result.wednesday.isNotEmpty())
        assertTrue(result.thursday.isNotEmpty())
        assertTrue(result.friday.isNotEmpty())
        assertTrue(result.saturday.isNotEmpty())
        assertTrue(result.sunday.isNotEmpty())
        runBlocking { delay(3000) }
    }
}