package  com.curtesmalteser.tragicintroductiontokoinandcoroutines.network.model.response

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by António 'Curtes Malteser' Bastião on 23/07/2019.
 */
data class ErrorMessage (
    @SerializedName("timestamp")
    val timestamp: Date,
    @SerializedName("message")
    val message: String
)