package com.curtesmalteser.tragicintroductiontokoinandcoroutines

import android.app.Application
import com.curtesmalteser.tragicintroductiontokoinandcoroutines.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber.DebugTree
import timber.log.Timber


class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startTimber()

        // Start Koin
        this.initKoin()

    }

    private fun startTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }
}