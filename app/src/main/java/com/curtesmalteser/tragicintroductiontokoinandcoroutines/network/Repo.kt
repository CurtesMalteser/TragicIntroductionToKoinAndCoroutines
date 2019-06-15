package com.curtesmalteser.tragicintroductiontokoinandcoroutines.network

import com.google.gson.annotations.SerializedName

data class Repo(
    @SerializedName("type")
    val type: String,
    @SerializedName("sort")
    val sort: String,
    @SerializedName("direction")
    val direction: String
)