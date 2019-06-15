package com.curtesmalteser.tragicintroductiontokoinandcoroutines

import com.curtesmalteser.tragicintroductiontokoinandcoroutines.network.Api
import kotlinx.coroutines.delay
import timber.log.Timber

interface HelloRepository {
    suspend fun giveHello(): String
    suspend fun sayMyName(name: String): String
}

class HelloRepositoryImpl(controller: Controller, api: Api) : HelloRepository {

    init {
        Timber.d("this is my name ${controller.name}")
        api.printAPI()
    }

    override suspend fun sayMyName(name: String): String {
        delay(1000L)
        return name
    }

    override suspend fun giveHello(): String {
        delay(500L)
        return "Hello,"
    }
}