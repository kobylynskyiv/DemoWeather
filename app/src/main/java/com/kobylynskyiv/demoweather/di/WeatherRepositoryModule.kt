package com.kobylynskyiv.demoweather.di

import com.kobylynskyiv.demoweather.fragments.main.repository.WeatherRepository
import org.koin.dsl.module

val weatherRepositoryModule = module {
    factory { WeatherRepository(get()) }
}