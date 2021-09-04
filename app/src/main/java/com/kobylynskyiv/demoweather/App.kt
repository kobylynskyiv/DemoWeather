package com.kobylynskyiv.demoweather

import android.app.Application
import com.kobylynskyiv.demoweather.di.networkModule
import com.kobylynskyiv.demoweather.di.viewWeatherModelModule
import com.kobylynskyiv.demoweather.di.weatherRepositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber


class App : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@App)
            androidFileProperties()
            modules(listOf(
                networkModule,
                weatherRepositoryModule,
                viewWeatherModelModule))
        }
    }


}