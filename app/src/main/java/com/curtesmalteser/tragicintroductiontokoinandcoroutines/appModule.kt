package com.curtesmalteser.tragicintroductiontokoinandcoroutines

import com.curtesmalteser.tragicintroductiontokoinandcoroutines.network.Api
import com.curtesmalteser.tragicintroductiontokoinandcoroutines.network.GitHubService
import com.curtesmalteser.tragicintroductiontokoinandcoroutines.repository.HelloRepository
import com.curtesmalteser.tragicintroductiontokoinandcoroutines.repository.HelloRepositoryImpl
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { Controller() }

    single { Api().gitHubService }

    // single instance of HelloRepository
    single<HelloRepository> {
        HelloRepositoryImpl(
            get()
        )
    }

    // MyViewModel ViewModel
    viewModel { MyViewModel(get()) }
}