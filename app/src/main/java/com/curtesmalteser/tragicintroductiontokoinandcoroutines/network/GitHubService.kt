package com.curtesmalteser.tragicintroductiontokoinandcoroutines.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by António 'Curtes Malteser' Bastião on 15/06/2019.
 */
interface GitHubService {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Call<List<Repo>>
}