package fr.isen.unorganizedtripapp.network

data class Ville(
    var nom: String,
    var restaurants: List<Restaurant>,
    var hotels: List<Hotel>,
    var lieux: List<Lieu>
) {}
