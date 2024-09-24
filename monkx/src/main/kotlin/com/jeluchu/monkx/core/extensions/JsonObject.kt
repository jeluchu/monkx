package com.jeluchu.monkx.core.extensions

import com.jeluchu.monkx.core.models.Episode
import org.json.JSONArray
import org.json.JSONObject

fun JSONArray.toEpisodeList(): List<Episode> {
    val episodes = mutableListOf<Episode>()

    for (i in 0 until length()) {

        val jsonObject: JSONObject = getJSONObject(i)

        val number = jsonObject.getInt("episodio")
        val image = jsonObject.getString("thumb")
        val url = jsonObject.getString("url")

        episodes.add(
            Episode(
                number = number,
                image = image,
                url = url
            )
        )

    }
    return episodes
}