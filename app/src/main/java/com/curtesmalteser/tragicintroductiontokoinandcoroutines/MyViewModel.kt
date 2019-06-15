package com.curtesmalteser.tragicintroductiontokoinandcoroutines

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.curtesmalteser.tragicintroductiontokoinandcoroutines.network.Repo
import com.curtesmalteser.tragicintroductiontokoinandcoroutines.repository.HelloRepository
import kotlinx.coroutines.*
import timber.log.Timber
import kotlin.coroutines.CoroutineContext

class MyViewModel(private val repo: HelloRepository) : ViewModel() {

    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    val repoListLiveData = MutableLiveData<List<Repo>>()

    fun fetchRepos() {
        scope.launch {
            val repoList = repo.getListRepos("CurtesMalteser")

            repoListLiveData.postValue(repoList)
        }
    }

    fun cancelAllRequests() = coroutineContext.cancel()

}