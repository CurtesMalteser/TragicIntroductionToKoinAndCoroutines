package com.curtesmalteser.tragicintroductiontokoinandcoroutines.network

import retrofit2.Retrofit
import timber.log.Timber

class Api {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.github.com")
            //.addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun printAPI() = Timber.d("printAPI -> API!!! API!!! API!!! API!!! API!!! API!!!")


    val gitHubService
        get() = retrofit.create(GitHubService::class.java)

}