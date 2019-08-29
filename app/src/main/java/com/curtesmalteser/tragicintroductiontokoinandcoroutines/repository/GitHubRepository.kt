package com.curtesmalteser.tragicintroductiontokoinandcoroutines.repository

import com.curtesmalteser.tragicintroductiontokoinandcoroutines.network.GitHubService
import com.curtesmalteser.tragicintroductiontokoinandcoroutines.network.Repo
import okhttp3.ResponseBody

interface GitHubRepository {
    suspend fun getListRepos(user: String): List<Repo>?
    suspend fun getUserFromLocalServer(token: String, user: String): ResponseBody?
}

class GitHubRepositoryImpl(private val gitHubService: GitHubService) : BaseRepository(),
    GitHubRepository {

    override suspend fun getListRepos(user: String): List<Repo>? {
        val repoResponse = safeApiCall(
            call = { gitHubService.listReposAsync(user).await() },
            errorMessage = "Error Fetching Repos"
        )

        return repoResponse?.toList()
    }


    override suspend fun getUserFromLocalServer(token: String, user: String): ResponseBody? {

        return safeApiCall(
            call = {
                gitHubService.getUserAsync(token, user).await()
            },
            errorMessage = "Error Fetching Repos"
        )
    }

}