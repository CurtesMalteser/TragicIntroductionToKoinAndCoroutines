package com.curtesmalteser.tragicintroductiontokoinandcoroutines.network

/**
 * Created by António 'Curtes Malteser' Bastião on 15/06/2019.
 */
sealed class Result<out T: Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}