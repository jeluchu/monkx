package com.jeluchu.monkx.core.components

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.webkit.WebView

@SuppressLint("SetJavaScriptEnabled")
class ScrapperWebView @JvmOverloads constructor(
    context: Context,
    defStyle: Int = 0,
    attrs: AttributeSet? = null,
    defStylerRes: Int=0) : WebView(context,attrs,defStyle,defStylerRes) {

    init {
        settings.apply {
            javaScriptEnabled = true
        }
    }
}