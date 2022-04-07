package fr.isen.unorganizedtripapp.data

import com.google.gson.annotations.SerializedName
import fr.isen.unorganizedtripapp.data.Stop
import java.io.Serializable

data class Trip(
    @SerializedName("budget") val budget: String,
    @SerializedName("url_maps") val urlMaps: String,
    @SerializedName("arrets") val stops: List<Stop>
): Serializable {}