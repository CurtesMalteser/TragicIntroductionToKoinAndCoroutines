package com.curtesmalteser.tragicintroductiontokoinandcoroutines

import kotlinx.coroutines.delay
import timber.log.Timber

interface HelloRepository {
    suspend fun giveHello(): String
    suspend fun sayMyName(name: String): String
}

class HelloRepositoryImpl : HelloRepository {

    override suspend fun sayMyName(name: String): String {
        delay(1000L)
        return name
    }

    override suspend fun giveHello(): String {
        delay(500L)
        return "Hello,"
    }
}