package fr.isen.unorganizedtripapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.unorganizedtripapp.databinding.ActivityInProgressBinding

class InProgressActivity : AppCompatActivity() {
    lateinit var binding: ActivityInProgressBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInProgressBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}