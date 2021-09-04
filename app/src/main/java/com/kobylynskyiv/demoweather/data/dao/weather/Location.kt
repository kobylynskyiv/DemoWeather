package com.kobylynskyiv.demoweather.data.dao.weather

data class Location(
    val name: String,
    val region: String,
    val country: String,
    val lat: String,
    val lon: String,
    val tz_id: String,
    val localtime_epoch: String,
    val localtime: String,
)