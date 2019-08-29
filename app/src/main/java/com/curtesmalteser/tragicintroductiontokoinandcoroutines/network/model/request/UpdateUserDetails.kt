package  com.curtesmalteser.tragicintroductiontokoinandcoroutines.network.model.request

import com.google.gson.annotations.SerializedName

/**
 * Created by António 'Curtes Malteser' Bastião on 14/07/2019.
 */
data class UpdateUserDetails(
        @SerializedName("firstName")
        val firstName: String,
        @SerializedName("lastName")
        val lastName: String
)