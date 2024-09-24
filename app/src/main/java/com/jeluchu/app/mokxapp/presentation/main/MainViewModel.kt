package com.jeluchu.app.mokxapp.presentation.main

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeluchu.monkx.Monkx
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _result : MutableState<String?> = mutableStateOf(null)
    val result : State<String?> = _result

    fun exampleCombiningDirectoryAndDetail(context: Context) = viewModelScope.launch(Dispatchers.IO) {
        val animeDetail = Monkx
            .getAnime(context, "shigatsu-wa-kimi-no-uso-sub-espanol")

        val search = Monkx
            .getSearchAnime("Shigatsu wa Kimi no Uso")

        val servers = Monkx
            .getServers("shinkalion-change-the-world-episodio-23")

        val lastEpisodes = Monkx
            .getLastEpisodes()

        val broadcast = Monkx
            .getCalendar()


        _result.value = /*anime.toString() + */broadcast.toString()// + episodes.toString()
    }
}