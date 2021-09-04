package com.kobylynskyiv.demoweather.di

import com.kobylynskyiv.demoweather.fragments.main.models.WeatherViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewWeatherModelModule = module {
    viewModel { WeatherViewModel(get()) }
}
