package  com.curtesmalteser.tragicintroductiontokoinandcoroutines.network.model.response

import com.google.gson.annotations.SerializedName

/**
 * Created by António 'Curtes Malteser' Bastião on 28/06/2019.
 */
data class UserDetailsResponse(
        @SerializedName("firstName")
        var firstName: String,
        @SerializedName("lastName")
        var lastName: String,
        @SerializedName("email")
        var email: String,
        @SerializedName("userID")
        var userID: String
)