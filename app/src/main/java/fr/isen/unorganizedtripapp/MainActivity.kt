package fr.isen.unorganizedtripapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.unorganizedtripapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.homeActButton.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        binding.loginActButton.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.registerActButton.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.navActButton.setOnClickListener {
            startActivity(Intent(this, NavigationActivity::class.java))
        }

        binding.tripDetailsActButton.setOnClickListener {
            startActivity(Intent(this, TripDetailsActivity::class.java))
        }

        binding.locDetailsActButton.setOnClickListener {
            startActivity(Intent(this, LocationDetailsActivity::class.java))
        }

        binding.swapChoiceActButton.setOnClickListener {
            startActivity(Intent(this, SwapChoiceActivity::class.java))
        }
    }
}