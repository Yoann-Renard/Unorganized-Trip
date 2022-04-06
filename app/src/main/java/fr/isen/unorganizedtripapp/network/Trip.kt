package fr.isen.unorganizedtripapp.network

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Trip(
    @SerializedName("budget") val budget: String,
    @SerializedName("url_maps") val urlMaps: String,
    @SerializedName("arrets") val stops: List<Stop>
): Serializable {}