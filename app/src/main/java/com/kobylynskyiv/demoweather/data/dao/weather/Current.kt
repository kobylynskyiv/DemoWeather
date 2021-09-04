package com.kobylynskyiv.demoweather.data.dao.weather

import com.kobylynskyiv.demoweather.data.dao.weather.current_items.Condition

data class Current(
    val last_updated_epoch: String,
    val last_updated: String,
    val temp_c: String,
    val temp_f: String,
    val is_day: String,
    val condition: Condition,
    val wind_mph: String,
    val wind_kph: String,
    val wind_degree: String,
    val wind_dir: String,
    val pressure_mb: String,
    val pressure_in: String,
    val precip_mm: String,
    val precip_in: String,
    val humidity: String,
    val cloud: String,
    val feelslike_c: String,
    val feelslike_f: String,
    val vis_km: String,
    val vis_miles: String,
    val uv: String,
    val gust_mph: String,
    val gust_kph: String,
)