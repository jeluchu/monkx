package com.jeluchu.monkx.scrapper

import com.jeluchu.monkx.models.servers.Server
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

/**
 * Extract the information from the following website
 * @see <a href="https://monoschinos2.com/ver/shigatsu-wa-kimi-no-uso-episodio-1"></a>
 *
 * shigatsu-wa-kimi-no-uso-episodio-1  is the example
 *
 */
@OptIn(ExperimentalEncodingApi::class)
fun String.extractServers(): List<Server> {
    val document: Document = Jsoup.parse(this)
    return mutableListOf<Server>().apply {
        document.select("div.heroarea div.row div.col-md-12 ul.dropcaps li").forEach { server ->
            val urlBase64 = server.select("a").attr("data-player")
            val url = Base64.decode(urlBase64).toString(Charsets.UTF_8).substringAfter("=")
            val id = server.select("a").text().orEmpty().lowercase()

            Server(id = id, url = url)
        }
    }
}