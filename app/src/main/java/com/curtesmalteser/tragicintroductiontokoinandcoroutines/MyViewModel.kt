package com.curtesmalteser.tragicintroductiontokoinandcoroutines

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import timber.log.Timber

class MyViewModel(private val repo: HelloRepository) : ViewModel() {

    fun runSayHello() = runBlocking {
        try {
            sayHello("António")
        } catch (e: Exception) {
            Timber.d(e)
        }
    }


    private suspend fun sayHello(name: String) = coroutineScope {
        val sayHello = async { repo.giveHello() }
        Timber.d(sayHello.await())

        val nameResult = async { repo.sayMyName(name) }
        Timber.d(nameResult.await())
    }
}