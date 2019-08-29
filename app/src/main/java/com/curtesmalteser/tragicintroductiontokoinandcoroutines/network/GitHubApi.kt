package com.curtesmalteser.tragicintroductiontokoinandcoroutines.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

class GitHubApi {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            //.baseUrl("https://api.github.com")
            .baseUrl("http://10.0.2.2:8080") // localHost
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    val gitHubService: GitHubService
        get() = retrofit.create(GitHubService::class.java)

}