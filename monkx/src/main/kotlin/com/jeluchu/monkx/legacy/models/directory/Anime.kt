package com.ead.lib.monoschinos.models.directory

data class Anime(
    val title : String,
    val type : String,
    val year : Int,
    val image : String,
    val url : String
) {
    val seo get() = Properties.seoAnimeRegex.find(url)?.groupValues?.get(1) ?: "null"
}