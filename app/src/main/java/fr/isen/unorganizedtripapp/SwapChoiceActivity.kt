package fr.isen.unorganizedtripapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import fr.isen.unorganizedtripapp.adapters.SwapChoiceAdapter
import fr.isen.unorganizedtripapp.databinding.ActivitySwapChoiceBinding

class SwapChoiceActivity : AppCompatActivity() {
    lateinit var binding: ActivitySwapChoiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySwapChoiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        parseData()
    }

    fun parseData() {
        binding.swapList.layoutManager = LinearLayoutManager(this)
        binding.swapList.adapter = SwapChoiceAdapter()
    }
}