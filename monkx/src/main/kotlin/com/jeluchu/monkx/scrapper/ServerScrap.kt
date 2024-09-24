package com.jeluchu.monkx.scrapper

import com.jeluchu.monkx.core.utils.AnimeDetailStructure
import com.jeluchu.monkx.core.utils.ServerStructure
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
    return document.select(ServerStructure.SERVER_LIST).map { server ->
        Server(
            id = server.text(),
            url = Base64.decode(server.attr(ServerStructure.DATA_PLAYER)).toString(Charsets.UTF_8)
        )
    }
}