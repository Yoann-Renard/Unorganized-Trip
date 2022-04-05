package fr.isen.unorganizedtripapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.unorganizedtripapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listenClickTrip()
    }

    fun listenClickTrip() {
        binding.monaco.setOnClickListener {
            showTrip(TripDestination.MONACO)
        }
        binding.bordeaux.setOnClickListener {
            showTrip(TripDestination.BORDEAUX)
        }
        binding.lyon.setOnClickListener {
            showTrip(TripDestination.LYON)
        }
    }

    private fun showTrip(city: TripDestination) {
        val intent = Intent(this, TripDetailsActivity::class.java)
        intent.putExtra(DestinationCity, city)
        startActivity(intent)
    }

    companion object {
        const val DestinationCity = "DestinationCity"
    }
}