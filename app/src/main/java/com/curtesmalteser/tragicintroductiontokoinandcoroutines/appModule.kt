package com.curtesmalteser.tragicintroductiontokoinandcoroutines

import com.curtesmalteser.tragicintroductiontokoinandcoroutines.network.GitHubApi
import com.curtesmalteser.tragicintroductiontokoinandcoroutines.repository.GitHubRepository
import com.curtesmalteser.tragicintroductiontokoinandcoroutines.repository.GitHubRepositoryImpl
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { Controller() }

    single { GitHubApi().gitHubService }

    // single instance of GitHubRepository
    single<GitHubRepository> {
        GitHubRepositoryImpl(
            get()
        )
    }

    // MyViewModel ViewModel
    viewModel { MainViewModel(get()) }
}