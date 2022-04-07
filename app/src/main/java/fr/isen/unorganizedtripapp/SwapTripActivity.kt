package fr.isen.unorganizedtripapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.unorganizedtripapp.databinding.ActivitySwapTripBinding

class SwapTripActivity : MenuActivity() {
    lateinit var binding: ActivitySwapTripBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySwapTripBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listenClickSwapTrip()
    }

    fun listenClickSwapTrip() {
        binding.lowBudgetTrip.setOnClickListener {
            showTrip(TripBudget.FAIBLE)
        }
        binding.classicBudgetTrip.setOnClickListener {
            showTrip(TripBudget.MOYEN)
        }
        binding.highBudgetTrip.setOnClickListener {
            showTrip(TripBudget.ELEVE)
        }
    }

    private fun showTrip(budget: TripBudget) {
        val intent = Intent(this, TripDetailsActivity::class.java)
        intent.putExtra(Budget, budget)
        startActivity(intent)
    }

    companion object {
        const val Budget = "Budget"
    }
}