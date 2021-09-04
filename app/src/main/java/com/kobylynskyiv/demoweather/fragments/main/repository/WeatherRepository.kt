package com.kobylynskyiv.demoweather.fragments.main.repository

import com.kobylynskyiv.demoweather.BuildConfig
import com.kobylynskyiv.demoweather.data.api.WeatherApi
import com.kobylynskyiv.demoweather.data.enums.ApiStatus
import com.kobylynskyiv.demoweather.data.enums.EApiStatus
import timber.log.Timber
import java.io.IOException

class WeatherRepository(private val weatherApi: WeatherApi) {

    suspend fun getWeather(city: String): ApiStatus {

        if (!isNetworkAvailable()) {
            return ApiStatus(
                EApiStatus.ERROR,
                null)
        }

        return try {
            ApiStatus(
                EApiStatus.SUCCESS,
                weatherApi.getWeather(BuildConfig.HOST, BuildConfig.KEY, city))
        } catch (e: Exception) {
            Timber.d(e)
            ApiStatus(
                EApiStatus.ERROR,
                null)
        }
    }

    private fun isNetworkAvailable(): Boolean {
        val runtime = Runtime.getRuntime()
        try {
            val ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8")
            val exitValue = ipProcess.waitFor()
            return exitValue == 0
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        return false
    }

}