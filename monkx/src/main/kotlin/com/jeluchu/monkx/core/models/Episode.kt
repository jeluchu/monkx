package com.jeluchu.monkx.core.models

import com.jeluchu.monkx.core.utils.Properties

data class Episode(
    val number : Int,
    val image : String,
    val url : String
) {
    val seo get() = Properties.seoChapterRegex.find(url)?.groupValues?.get(1) ?: "null"
}