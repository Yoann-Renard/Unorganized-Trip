package fr.isen.unorganizedtripapp.network

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class RequestResult (@SerializedName("trajets") val data: List<Trip>): Serializable {}