package com.curtesmalteser.tragicintroductiontokoinandcoroutines.di

import android.app.Application
import com.curtesmalteser.tragicintroductiontokoinandcoroutines.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by António 'Curtes Malteser' Bastião on 29/08/2019.
 */

fun Application.initKoin() {
    startKoin {
        androidLogger()
        androidContext(applicationContext)
        modules(appModule)
    }
}