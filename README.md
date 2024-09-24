
![Monkx Banner](https://raw.githubusercontent.com/jeluchu/monkx/develop/assets/monkx.png)    
[![Discord Server](https://img.shields.io/discord/460491088004907029.svg?style=flat&logo=discord)](https://discord.gg/2DZHfxv9XN)  [![](https://jitpack.io/v/jeluchu/monkx.svg)](https://jitpack.io/#jeluchu/monkx)

Wrapper for [MonosChinos Web](https://monoschinos2.com/) build using Kotlin + Kotlin DSL + Coroutines power 🚀

# Installation
with Gradle
```groovy  
repositories {   
	maven { url 'https://jitpack.io' }  
}  
  
dependencies {  
	implementation("com.github.jeluchu:monkx:1.0.0")
}  
```  
# Example
```kotlin  
fun main() {  
	val anime = runBlocking { Monkx.getAnime("shigatsu-wa-kimi-no-uso-sub-espanol") } 
	println(anime.title) // Prints: Shigatsu wa Kimi no Uso
}  
```      

# Available requests

- **Search:** Using Monkx, you can call the request, `getSearchAnime(anime: String)` and after passing it the query from which you want to obtain information it will return a list.

- **Anime:** Using Monkx, you can call the request, `getAnime(anime: String)` and after passing it the query from which you want to obtain information it will return a object.

- **Servers:** Using Monkx, you can call the request, `getServers(id: String)` and after passing it the query from which you want to obtain information it will return a list with available servers.

- **Last Episodes:** Using Monkx, you can call the request, `getLastEpisodes()` and after calling this method, the request will return a list of all recent episodes.

- **Calendar:** Using Monkx, you can call the request, `getCalendar()` and after calling this method, the request will return a list of all animes in the week.

- **Broadcast:** Using Monkx, you can call the request, `getBroadcast()` and after calling this method, the request will return a list of all animes on air. ***(Note: This request has a delay of 3 seconds per request as it makes requests for all the pages that are available.)***

# Objets

### Search return AnimeSearch object
```kotlin  
data class AnimeSearch(  
	val title: String,  
	val image: String,  
	val type: String,  
	val year: String  
)
```

### Anime return AnimeInfo object
```kotlin  
data class AnimeInfo(  
	val title: String,  
	val image: String,  
	val cover: String,  
	val synopsis: String,  
	val state: String,  
	val type: String,  
	val genres: List<String>,  
	val episodesCount: Int,  
	val episodes: List<AnimeEpisode>
)

// AnimeEpisode is this object
data class AnimeEpisode(  
	val id: String,  
	val number: Int  
)
```

### Servers return Server object
```kotlin  
data class AnimeInfo(  
	val id: String,  
	val url: String
)
```

### LastEpisodes return Server object
```kotlin  
data class Episode(  
	val title: String,  
	val episodeNumber: Int,  
	val type: String,  
	val image: String,   
	val url: String,  
	val id: String  
)
```

### Calendar return WeekCalendar object
```kotlin  
data class WeekCalendar(  
	var monday: List<AnimeCalendar>,   
	var tuesday: List<AnimeCalendar>,  
	var wednesday: List<AnimeCalendar>,  
	var thursday: List<AnimeCalendar>,  
	var friday: List<AnimeCalendar>,  
	var saturday: List<AnimeCalendar>,  
	var sunday: List<AnimeCalendar>
)

// AnimeCalendar is this object
data class AnimeCalendar(  
	val title: String,  
	val episodeNumber: Int,  
	val image: String,  
	val genres: List<String>  
)
```

### Broadcast return Broadcast object
```kotlin  
data class Broadcast(   
	val title: String,  
	val url: String,  
	val image: String,  
	val id: String  
)
```

# Release
For latest release or to check the changelogs, please check Release tab.

# Contribution
Want to help? I'm very open to contributors so just do it or contact me if you have any question (Discord: jeluchu)