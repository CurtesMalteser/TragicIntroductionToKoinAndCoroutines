package com.curtesmalteser.tragicintroductiontokoinandcoroutines

import com.curtesmalteser.tragicintroductiontokoinandcoroutines.network.Api
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { Controller() }
    single { Api() }

    // single instance of HelloRepository
    single<HelloRepository> { HelloRepositoryImpl(get(), get()) }

    // MyViewModel ViewModel
    viewModel { MyViewModel(get()) }
}