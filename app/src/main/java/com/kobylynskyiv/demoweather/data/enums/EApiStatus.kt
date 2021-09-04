package com.kobylynskyiv.demoweather.data.enums

import com.kobylynskyiv.demoweather.data.api.Weather

data class ApiStatus(val status: EApiStatus, val weather: Weather?)

enum class EApiStatus {
    ERROR,
    SUCCESS
}