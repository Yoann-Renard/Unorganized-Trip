package fr.isen.unorganizedtripapp.network

data class Trip(
    var nom: String,
    var villes: List<Ville>
) {}