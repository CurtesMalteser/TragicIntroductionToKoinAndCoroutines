package com.curtesmalteser.tragicintroductiontokoinandcoroutines.repository

import com.curtesmalteser.tragicintroductiontokoinandcoroutines.network.GitHubService
import com.curtesmalteser.tragicintroductiontokoinandcoroutines.network.Repo
import com.curtesmalteser.tragicintroductiontokoinandcoroutines.network.model.request.UserDetailsRequest
import com.curtesmalteser.tragicintroductiontokoinandcoroutines.network.model.response.UserDetailsResponse

interface GitHubRepository {
    suspend fun signUpUser(userDetails: UserDetailsRequest): UserDetailsResponse?
    suspend fun getUserFromLocalServer(token: String, user: String): UserDetailsResponse?
}

class GitHubRepositoryImpl(private val gitHubService: GitHubService) : BaseRepository(),
    GitHubRepository {

    override suspend fun signUpUser(userDetails: UserDetailsRequest): UserDetailsResponse? {
        return safeApiCall(
            call = {
                gitHubService.postSignUpAsync("", userDetails).await()
            },
            errorMessage = "Error Fetching Repos"
        )
    }
    override suspend fun getUserFromLocalServer(token: String, user: String): UserDetailsResponse? {

        return safeApiCall(
            call = {
                gitHubService.getUserAsync(token, user).await()
            },
            errorMessage = "Error Fetching Repos"
        )
    }

}