package com.curtesmalteser.tragicintroductiontokoinandcoroutines.network

import com.curtesmalteser.tragicintroductiontokoinandcoroutines.network.model.request.UpdateUserDetails
import com.curtesmalteser.tragicintroductiontokoinandcoroutines.network.model.request.UserDetailsRequest
import com.curtesmalteser.tragicintroductiontokoinandcoroutines.network.model.request.UserLoginRequestModel
import com.curtesmalteser.tragicintroductiontokoinandcoroutines.network.model.response.OperationStatus
import com.curtesmalteser.tragicintroductiontokoinandcoroutines.network.model.response.UserDetailsResponse
import com.curtesmalteser.tragicintroductiontokoinandcoroutines.network.model.response.UsersListRest
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
    fun postSignUpAsync(@Header("Authorization") token: String, @Body userDetails: UserDetailsRequest): Deferred<Response<UserDetailsResponse>>

    @POST("users/login") // returns empty response body but headers contain token and userID
    fun postSignInAsync(@Body userLoginRequestModel: UserLoginRequestModel): Deferred<Response<ResponseBody>>

    @PUT("users/login")
    fun putUpdateUserAsync(@Header("Authorization") token : String, @Body updateUserDetails: UpdateUserDetails): Deferred<Response<UserDetailsResponse?>>

    @GET("users/{userID}")
    fun getUserAsync(@Header("Authorization") token : String, @Path("userID") user: String): Deferred<Response<UserDetailsResponse>>

    //todo -> add query param //@GET("users")
    // fun getUsersLisAsync(@Header("Authorization") token : String, @Path("user") user: String): Deferred<Response<UsersListRest>>

    @DELETE("users/login")
    fun deleteUserAsync(@Header("Authorization") token : String): Deferred<Response<OperationStatus>>
}