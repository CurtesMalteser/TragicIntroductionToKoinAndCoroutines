package  com.curtesmalteser.tragicintroductiontokoinandcoroutines.network.model.request

import com.google.gson.annotations.SerializedName

/**
 * Created by António 'Curtes Malteser' Bastião on 01/07/2019.
 */
data class UserDetailsRequest(
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)