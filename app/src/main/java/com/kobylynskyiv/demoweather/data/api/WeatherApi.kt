package com.kobylynskyiv.demoweather.data.api

import com.kobylynskyiv.demoweather.data.dao.weather.Current
import com.kobylynskyiv.demoweather.data.dao.weather.Location
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface WeatherApi {

    @GET("forecast.json")
    suspend fun getWeather(
        @Header("x-rapidapi-host") host: String,
        @Header("x-rapidapi-key") key: String,
        @Query("q") city: String,
        @Query("lang") lang: String = "ru",
    ): Weather
}

data class Weather(val location: Location, val current: Current, val forecast: Nothing? = null)
