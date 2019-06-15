package com.curtesmalteser.tragicintroductiontokoinandcoroutines.network

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by António 'Curtes Malteser' Bastião on 15/06/2019.
 */
interface GitHubService {
    @GET("users/{user}/repos")
    fun listReposAsync(@Path("user") user: String): Deferred<Response<List<Repo>>>
}