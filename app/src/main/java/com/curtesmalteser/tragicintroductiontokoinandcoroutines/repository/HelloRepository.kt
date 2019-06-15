package com.curtesmalteser.tragicintroductiontokoinandcoroutines.repository

import com.curtesmalteser.tragicintroductiontokoinandcoroutines.network.Api
import com.curtesmalteser.tragicintroductiontokoinandcoroutines.network.GitHubService
import com.curtesmalteser.tragicintroductiontokoinandcoroutines.network.Repo

interface HelloRepository {
    suspend fun getListRepos(user: String): List<Repo>?
}

class HelloRepositoryImpl(private val gitHubService: GitHubService) : BaseRepository(),
    HelloRepository {

    override suspend fun getListRepos(user: String): List<Repo>? {
        val repoResponse = safeApiCall(
            call = { gitHubService.listReposAsync(user).await()},
            errorMessage = "Error Fetching Repos"
        )

        return repoResponse?.toList()
    }

}