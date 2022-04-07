package fr.isen.unorganizedtripapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import fr.isen.unorganizedtripapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listenClick()
    }

    private fun listenClick() {
        binding.validButton.setOnClickListener {
            if (binding.monacoButton.isChecked) {
                when (binding.budgetSeekBar.progress) {
                    1 -> {
                        showTrip(TripDestination.MONACO, TripBudget.FAIBLE)
                    }
                    2 -> {
                        showTrip(TripDestination.MONACO, TripBudget.MOYEN)
                    }
                    3 -> {
                        showTrip(TripDestination.MONACO, TripBudget.ELEVE)
                    }
                }
            } else if (binding.bordeauxButton.isChecked || binding.lyonButton.isChecked) {
                startActivity(Intent(this, InProgressActivity::class.java))
            }
        }
    }

    private fun showTrip(destination: TripDestination, budget: TripBudget) {
        val intent = Intent(this, TripDetailsActivity::class.java)
        intent.putExtra(DestinationCity, destination)
        intent.putExtra(Budget, budget)
        startActivity(intent)
    }

    companion object {
        const val DestinationCity = "DestinationCity"
        const val Budget = "Budget"
    }
}