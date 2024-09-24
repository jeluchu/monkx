package com.jeluchu.monkx.core.utils

object AnimeDetailStructure {
    const val TITLE = "div.bg-transparent.p-3.h-100.scroll-x-md dl > :nth-child(6)"
    const val ALTERNATIVE_TITLE = "div.bg-transparent.p-3.h-100.scroll-x-md dl > :nth-child(8)"
    const val STATUS = "div.ms-2:nth-of-type(1) > :nth-child(2)"
    const val COVER_IMAGE = "div.d-sm-none.tarjeta.position-relative.p-0 div.col-12 img"
    const val PROFILE_IMAGE = "div.mt-5.mb-2.d-flex.d-none.d-sm-flex.gap-3 div img"
    const val RELEASE = "div.bg-transparent.p-3.h-100.scroll-x-md dl > :nth-child(4)"
    const val SYNOPSIS = "div.mb-3 p"
    const val GENRES = "span.badge.bg-secondary"
}

object Properties {

    const val BASE_URL = "https://darkryh.github.io/MonosChinosApi/"
    const val HOME_API = "HomeStructure.json"
    const val ANIME_DETAIL_API = "AnimeDetailStructure.json"
    const val ANIME_PAGE_API = "AnimePageQuery.json"
    const val ANIME_SEARCH_API = "AnimeSearchQuery.json"
    const val PLAYER_API = "PlayerStructure.json"

    const val HOME_PAGE = "https://monoschinos2.com/"
    const val QUERY_PAGE = "animes?p="
    const val QUERY_SEARCH = "buscar?q="
    const val PLAY_PAGE = "ver/"
    const val ANIME_QUERY = "anime/"

    const val CAP_BLANK_MC2 = "https://monoschinos2.com/public/img/capblank.png"
    const val CAP_BLANK_ANIME_MC2 = "https://monoschinos2.com/public/img/anime.png"

    val seoChapterRegex = "/ver/([^/]+)".toRegex()
    val seoAnimeRegex = "/anime/([^/]+)".toRegex()
}