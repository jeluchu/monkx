package com.jeluchu.monkx.core.connection

import com.jeluchu.monkx.core.client.MonkxClient
import com.jeluchu.monkx.core.exception.MonkxException
import com.jeluchu.monkx.core.utils.Log
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpHeaders
import io.ktor.http.headers

/**
 * Class that handle request.
 * @param isDebug: a boolean that indicate if you run it on debug or not. If yes, it'll throw exception if something happen.
 * @param url: Custom URL, will use default (Jikan URL) if null or empty.
 */
class RestClient(private val isDebug: Boolean = false, private val url: String? = null) : MonkxClient() {
    private val client = httpClient
    private val usedURL = if (url.isNullOrEmpty()) BASE_URL else url

    suspend fun request(endPoint: String): String {
        runCatching {
            val response = client.get(usedURL + endPoint) {
                headers {
                    append(HttpHeaders.Accept, "text/html")
                }
            }

            val body = response.bodyAsText()
            //val contentType = response.headers["Content-Type"]
            //val te = if (contentType?.equals("text/html", true) == true) {
            //    gson.fromJson(body, JsonElement::class.java)
            //} else null

            if (response.status.value !in 200..299) {
                if (response.status.value in 500..599) {
                    val ex = Exception("An internal server error has occurred, code: ${response.status.value}")
                    if (isDebug) throw ex else exceptionHandler(ex)
                } else {
                    val ex = MonkxException(
                        "Jikan API returns code ${response.status.value} and body ${body?.toString()}",
                        response.status.value
                    )

                    if (isDebug) throw ex
                    else exceptionHandler(ex)
                }
            }

            return body
        }.getOrElse { throwable -> throw throwable }
    }

    private fun exceptionHandler(ex: Exception, message: String? = null) {
        if (message.isNullOrEmpty()) Log.error("Something went wrong! Exception: ${ex.localizedMessage}")
        else Log.error(ex, "Something went wrong! Exception: ${ex.localizedMessage}")
    }

    companion object {
        const val BASE_URL = "https://monoschinos2.com/"
    }
}