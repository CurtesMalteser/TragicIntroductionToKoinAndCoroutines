package com.curtesmalteser.tragicintroductiontokoinandcoroutines.network

import com.google.gson.annotations.SerializedName

data class Repo(
    @SerializedName("name")
    val name: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("updated_at")
    val updatedAt: String
)