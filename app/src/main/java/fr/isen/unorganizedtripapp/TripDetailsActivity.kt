package fr.isen.unorganizedtripapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import fr.isen.unorganizedtripapp.adapters.TripDetailsAdapter
import fr.isen.unorganizedtripapp.databinding.ActivityTripDetailsBinding
import fr.isen.unorganizedtripapp.network.RequestResult
import fr.isen.unorganizedtripapp.network.Stop
import fr.isen.unorganizedtripapp.network.Trip
import java.io.IOException


enum class TripDestination {
    MONACO, BORDEAUX, LYON;

    companion object {
        fun getDest(trip: TripDestination): String {
            return when (trip) {
                MONACO -> "Monaco"
                BORDEAUX -> "Bordeaux"
                LYON -> "Lyon"
            }
        }
    }
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


class TripDetailsActivity : AppCompatActivity() {
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

        listenClickSwap()
    }

    private fun listenClickSwap() {
        binding.detailSwapButton.setOnClickListener {
            val intent = Intent(this, SwapTripActivity::class.java)
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
        binding.detailList.adapter = TripDetailsAdapter(trip)
    }
}