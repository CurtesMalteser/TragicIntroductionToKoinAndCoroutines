package com.curtesmalteser.tragicintroductiontokoinandcoroutines

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.curtesmalteser.tragicintroductiontokoinandcoroutines.network.Repo
import com.curtesmalteser.tragicintroductiontokoinandcoroutines.network.model.request.UserDetailsRequest
import com.curtesmalteser.tragicintroductiontokoinandcoroutines.repository.GitHubRepository
import kotlinx.coroutines.*
import timber.log.Timber
import kotlin.coroutines.CoroutineContext

class MainViewModel(private val repo: GitHubRepository) : ViewModel() {

    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    val repoListLiveData = MutableLiveData<List<Repo>>()

    init {
        signUp(UserDetailsRequest(
            firstName = "AJ",
            lastName = "DB",
            email ="aj@db.com",
            password = "ajdb1234"
        ))
    }

  fun signUp(userDetails: UserDetailsRequest) {
      scope.launch {
          //val repoList = repo.getListRepos("CurtesMalteser")
          val repoList = repo.signUpUser(userDetails = userDetails)

          Timber.d("AJDB signUp -> ${repoList}")

          //repoListLiveData.postValue(repoList)
      }
  }


    fun fetchRepos() {
        scope.launch {
            //val repoList = repo.getListRepos("CurtesMalteser")
            val repoList = repo.getUserFromLocalServer(
                token = "BearereyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJjdXJ0ZXNAbWFsdGVzZXIuY29tIiwiZXhwIjoxNTY3MTk0NTA0fQ.UhqU5W-MiJTaA-A0PfJdqY8w6IFs3KGcJrj8DxU4jL455hnU3ukajjEY_FtPF9uqyiQ8cRlaiSDmOjAZSBND8A",
                user = "f7f78309-c862-4537-a7d1-a4c539942c41"
            )

            Timber.d("AJDB -> ${repoList}")

            //repoListLiveData.postValue(repoList)
        }
    }


    fun cancelAllRequests() = coroutineContext.cancel()

}