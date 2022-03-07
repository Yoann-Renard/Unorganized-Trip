package fr.isen.unorganizedtripapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.unorganizedtripapp.databinding.ActivityLocationDetailsBinding

class LocationDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityLocationDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLocationDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.swapButton.setOnClickListener {
            val intent = Intent(this, SwapChoiceActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}