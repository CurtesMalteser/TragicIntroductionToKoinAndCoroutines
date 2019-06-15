package com.curtesmalteser.tragicintroductiontokoinandcoroutines.repository

import com.curtesmalteser.tragicintroductiontokoinandcoroutines.network.GitHubService
import com.curtesmalteser.tragicintroductiontokoinandcoroutines.network.Repo

interface GitHubRepository {
    suspend fun getListRepos(user: String): List<Repo>?
}

class GitHubRepositoryImpl(private val gitHubService: GitHubService) : BaseRepository(),
    GitHubRepository {

    override suspend fun getListRepos(user: String): List<Repo>? {
        val repoResponse = safeApiCall(
            call = { gitHubService.listReposAsync(user).await()},
            errorMessage = "Error Fetching Repos"
        )

        return repoResponse?.toList()
    }

}