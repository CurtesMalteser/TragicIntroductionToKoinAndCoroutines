package com.curtesmalteser.tragicintroductiontokoinandcoroutines

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import timber.log.Timber

class MyViewModel(private val repo : HelloRepository) : ViewModel() {

    fun sayHello(name: String) {
        runBlocking {
            launch {
                val sayHello = repo.giveHello()


                Timber.d(sayHello)

                val nameResult = repo.sayMyName(name)

                Timber.d(nameResult)

            }
        }
    }
}