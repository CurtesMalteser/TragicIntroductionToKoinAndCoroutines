package com.curtesmalteser.tragicintroductiontokoinandcoroutines

import android.app.Application
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
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(appModule)
        }


    }

    fun startTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }
}