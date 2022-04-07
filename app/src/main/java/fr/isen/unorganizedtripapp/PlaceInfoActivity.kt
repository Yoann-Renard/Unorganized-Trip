package fr.isen.unorganizedtripapp

import android.content.Intent
import android.os.Bundle
import com.squareup.picasso.Picasso
import fr.isen.unorganizedtripapp.databinding.ActivityPlaceInfoBinding
import fr.isen.unorganizedtripapp.data.Stop

class PlaceInfoActivity : MenuActivity() {
    lateinit var binding: ActivityPlaceInfoBinding
    lateinit var currentPlace: Stop
    lateinit var currentBudget: TripBudget

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaceInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        currentPlace = intent.getSerializableExtra(TripDetailsActivity.SelectedPlace) as Stop
        currentBudget = intent.getSerializableExtra(TripDetailsActivity.Budget) as TripBudget

        setupInfo()

        binding.infoBackButton.setOnClickListener {
            val intent = Intent(this, TripDetailsActivity::class.java)
            intent.putExtra(Budget, currentBudget)
            startActivity(intent)
        }
    }

    private fun setupInfo() {
        Picasso
            .get()
            .load(currentPlace.img)
            .into(binding.infoImg)

        binding.infoName.text = currentPlace.name
        binding.infoCity.text = currentPlace.city
        binding.infoDesc.text = currentPlace.desc
    }

    companion object {
        const val Budget = "Budget"
    }
}