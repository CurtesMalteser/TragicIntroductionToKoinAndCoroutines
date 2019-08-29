package com.curtesmalteser.tragicintroductiontokoinandcoroutines.network

import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

/**
 * Created by António 'Curtes Malteser' Bastião on 15/06/2019.
 */
interface GitHubService {
    @GET("users/{user}/repos")
    fun listReposAsync(@Path("user") user: String): Deferred<Response<List<Repo>>>

    @POST("users")
    fun postSignUpAsync(@Body user: String): Deferred<Response<ResponseBody>>

    @POST("users/login")
    fun postSignInAsync(@Body user: String): Deferred<Response<ResponseBody>>

    @PUT("users/login")
    fun putUpdateUserAsync(@Header("Authorization") token : String, @Body user: String): Deferred<Response<ResponseBody>>

    @GET("users/{userID}")
    fun getUserAsync(@Header("Authorization") token : String, @Path("userID") user: String): Deferred<Response<ResponseBody>>

    @GET("users") // todo -> add query param
    fun getUsersLisAsync(@Header("Authorization") token : String, @Path("user") user: String): Deferred<Response<ResponseBody>>

    @DELETE("users/login")
    fun deleteUserAsync(@Header("Authorization") token : String, @Body user: String): Deferred<Response<ResponseBody>>
}