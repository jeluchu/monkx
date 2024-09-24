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

object SearchStructure {
    const val CLASS_LIST = "li.col.mb-5.ficha_efecto"
    const val TITLE = "a h3"
    const val TYPE = "a div div span"
    const val YEAR = "a span.text-muted"
    const val IMAGE = "a div img"
    const val URL = "a"
}

object ServerStructure {
    const val DATA_PLAYER = "data-player"
    const val SERVER_LIST = "button.play-video"
}

object LastEpisodesStructure {
    const val CLASS_LIST = "li.col.mb-4:not(.ficha_efecto)"
    const val TITLE = "article h2"
    const val NUMBER = "article a div span.episode"
    const val TYPE = "article span.my-1"
    const val IMAGE = "article a div img"
    const val URL = "article a"
}

object CalendarStructure {
    const val TITLE = "h3"
    const val IMAGE = "img"
    const val IMAGE_ATTR = "data-src"
    const val URL = "a"
    const val URL_ATTR = "a"
    const val EPISODE_NUMBER = "span.badge"
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