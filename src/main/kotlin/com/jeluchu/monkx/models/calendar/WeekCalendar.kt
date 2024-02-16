package com.jeluchu.monkx.models.calendar

/**
 * WeekCalendar data class.
 */
data class WeekCalendar(
    /**
     * List of animes in streaming for monday.
     * @see AnimeCalendar
     */
    var monday: List<AnimeCalendar> = emptyList(),

    /**
     * List of animes in streaming for tuesday.
     * @see AnimeCalendar
     */
    var tuesday: List<AnimeCalendar> = emptyList(),

    /**
     * List of animes in streaming for wednesday.
     * @see AnimeCalendar
     */
    var wednesday: List<AnimeCalendar> = emptyList(),

    /**
     * List of animes in streaming for thursday.
     * @see AnimeCalendar
     */
    var thursday: List<AnimeCalendar> = emptyList(),

    /**
     * List of animes in streaming for friday.
     * @see AnimeCalendar
     */
    var friday: List<AnimeCalendar> = emptyList(),

    /**
     * List of animes in streaming for saturday.
     * @see AnimeCalendar
     */
    var saturday: List<AnimeCalendar> = emptyList(),

    /**
     * List of animes in streaming for sunday.
     * @see AnimeCalendar
     */
    var sunday: List<AnimeCalendar> = emptyList()
)
