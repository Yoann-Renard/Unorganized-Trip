package fr.isen.unorganizedtripapp.network

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Stop(
    @SerializedName("nom") val name: String,
    @SerializedName("ville") val city: String,
    @SerializedName("img") val img: String,
    @SerializedName("description") val desc: String
): Serializable {}
