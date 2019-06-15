package com.curtesmalteser.tragicintroductiontokoinandcoroutines

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.curtesmalteser.tragicintroductiontokoinandcoroutines.network.Repo
import com.curtesmalteser.tragicintroductiontokoinandcoroutines.repository.GitHubRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainViewModel(private val repo: GitHubRepository) : ViewModel() {

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