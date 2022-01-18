package com.moralabs.istegelsin

import android.app.Application
import com.moralabs.istegelsin.di.MainPageDI
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class AppModule : Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger(Level.ERROR)
            androidContext(this@AppModule)
            modules(listOf(MainPageDI.appModule))
        }

    }
}