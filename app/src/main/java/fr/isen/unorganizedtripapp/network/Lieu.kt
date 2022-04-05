package fr.isen.unorganizedtripapp.network

data class Lieu(
    var nom: String,
    var img: String,
    var description: String,
    var prix: Int,
    var familial: Int,
    var confort: Int,
    var sportivité: Int
) {}