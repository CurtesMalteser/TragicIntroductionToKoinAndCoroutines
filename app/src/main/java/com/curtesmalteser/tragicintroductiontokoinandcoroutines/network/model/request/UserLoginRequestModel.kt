package  com.curtesmalteser.tragicintroductiontokoinandcoroutines.network.model.request

import com.google.gson.annotations.SerializedName

/**
 * Created by António 'Curtes Malteser' Bastião on 25/08/2019.
 */
data class UserLoginRequestModel(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)