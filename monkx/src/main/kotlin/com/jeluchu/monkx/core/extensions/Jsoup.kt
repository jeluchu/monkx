package com.jeluchu.monkx.core.extensions

import android.content.Context
import com.jeluchu.monkx.core.exception.ProviderException
import com.jeluchu.monkx.R
import com.jeluchu.monkx.core.utils.Properties
import kotlinx.coroutines.suspendCancellableCoroutine
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

fun Elements.getSrcAttr(): String {
    val result = attr("src")

    if (result == Properties.CAP_BLANK_MC2 || result == Properties.CAP_BLANK_ANIME_MC2  || result.isEmpty()) {
        return "data-src"
    }
    return "src"
}

fun Element.getSrcAttr(selectorQuery : String) : String {
    val result = select(selectorQuery).attr("src")

    if (result == Properties.CAP_BLANK_MC2 || result == Properties.CAP_BLANK_ANIME_MC2  || result.isEmpty()) {
        return "data-src"
    }
    return "src"
}