package com.kobylynskyiv.demoweather.fragments.main.models

import androidx.lifecycle.*
import com.kobylynskyiv.demoweather.data.enums.ApiStatus
import com.kobylynskyiv.demoweather.fragments.main.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers


class WeatherViewModel(
    private val repository: WeatherRepository,
) : ViewModel() {

    private val mutableWeather = MutableLiveData<String>()
    private val weather: LiveData<String> get() = mutableWeather


    fun textChange(city: String) {
        mutableWeather.value = city
    }

    val weatherData: LiveData<ApiStatus> = weather.switchMap { city ->
        liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
            emit(repository.getWeather(city))
        }
    }

}

