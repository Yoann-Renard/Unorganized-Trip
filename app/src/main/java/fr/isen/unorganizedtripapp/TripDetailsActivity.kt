package fr.isen.unorganizedtripapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import fr.isen.unorganizedtripapp.adapters.TripDetailsAdapter
import fr.isen.unorganizedtripapp.databinding.ActivityTripDetailsBinding
import fr.isen.unorganizedtripapp.data.RequestResult
import fr.isen.unorganizedtripapp.data.Stop
import java.io.IOException


enum class TripDestination {
    MONACO, BORDEAUX, LYON;
}

enum class TripBudget {
    FAIBLE, MOYEN, ELEVE;

    companion object {
        fun getBudget(budget: TripBudget): String {
            return when (budget) {
                FAIBLE -> "faible"
                MOYEN -> "moyen"
                ELEVE -> "eleve"
            }
        }
    }
}


class TripDetailsActivity : MenuActivity() {
    lateinit var binding: ActivityTripDetailsBinding
    lateinit var currentDestination: TripDestination
    lateinit var currentBudget: TripBudget

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("ACTIVITY", "Activity created: TripDetails")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trip_details)
        binding = ActivityTripDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        currentDestination = intent.getSerializableExtra(HomeActivity.DestinationCity) as? TripDestination ?: TripDestination.MONACO
        currentBudget = intent.getSerializableExtra(HomeActivity.Budget) as? TripBudget ?: TripBudget.MOYEN

        val jsonFile = getJsonDataFromAsset(applicationContext, "data_monaco.json")
        if (jsonFile != null) {
            Log.d("FILE", "JSON loaded.") // $jsonFile
            parseResult(jsonFile)
        }else{
            Log.d("FILE", "JSON file cannot be loaded.")
        }

        listenClick()
    }

    private fun listenClick() {
        binding.detailSwapButton.setOnClickListener {
            val intent = Intent(this, SwapTripActivity::class.java)
            startActivity(intent)
        }
        binding.detailValidButton.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            intent.putExtra(Budget, currentBudget)
            startActivity(intent)
        }
    }

    private fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use {
                it.readText()
            }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    private fun parseResult(json: String?) {
        val result = GsonBuilder().create().fromJson(json, RequestResult::class.java)
        val trip = result.data.first {
            it.budget == TripBudget.getBudget(currentBudget)
        }.stops
        Log.d("PARSE", "List of stops: $trip")

        binding.detailList.layoutManager = LinearLayoutManager(this)
        binding.detailList.adapter = TripDetailsAdapter(trip) {
            showDetails(it)
        }
    }

    private fun showDetails(stop: Stop) {
        val intent = Intent(this, PlaceInfoActivity::class.java)
        intent.putExtra(SelectedPlace, stop)
        intent.putExtra(Budget, currentBudget)
        startActivity(intent)
    }

    companion object {
        const val SelectedPlace = "SelectedPlace"
        const val Budget = "Budget"
    }
}