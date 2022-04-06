package fr.isen.unorganizedtripapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.unorganizedtripapp.databinding.ActivitySwapTripBinding

class SwapTripActivity : AppCompatActivity() {
    lateinit var binding: ActivitySwapTripBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySwapTripBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}