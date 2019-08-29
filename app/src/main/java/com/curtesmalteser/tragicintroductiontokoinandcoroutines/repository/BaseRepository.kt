package com.curtesmalteser.tragicintroductiontokoinandcoroutines.repository

import com.curtesmalteser.tragicintroductiontokoinandcoroutines.network.Result
import retrofit2.Response
import timber.log.Timber
import java.io.IOException

/**
 * Created by António 'Curtes Malteser' Bastião on 15/06/2019.
 */
open class BaseRepository {

    suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>, errorMessage: String): T? {

        val result: Result<T> = safeApiResult(call, errorMessage)
        var data: T? = null

        when (result) {
            is Result.Success ->
                data = result.data
            is Result.Error -> {
                Timber.e("$errorMessage & Exception - ${result.exception}")
            }
        }

        return data

    }

    private suspend fun <T : Any> safeApiResult(
        call: suspend () -> Response<T>,
        errorMessage: String
    ): Result<T> {
        val response = call.invoke()
        if (response.isSuccessful) return Result.Success(
            response.body()!!
        )

        return Result.Error(IOException("Error Occurred during getting safe Api result, Custom ERROR - $errorMessage\nResponse code : ${response.code()}"))
    }
}