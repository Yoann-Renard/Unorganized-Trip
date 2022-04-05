package fr.isen.unorganizedtripapp

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.database.util.JsonMapper
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import fr.isen.unorganizedtripapp.adapters.TripDetailsAdapter
import fr.isen.unorganizedtripapp.databinding.ActivityTripDetailsBinding
import fr.isen.unorganizedtripapp.network.RequestResult
import fr.isen.unorganizedtripapp.network.Trip
import fr.isen.unorganizedtripapp.network.TripDetails
import fr.isen.unorganizedtripapp.network.Ville
import java.io.IOException
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.reflect.typeOf


enum class TripDestination {
    MONACO, BORDEAUX, LYON;

    companion object {
        fun getDestination(dest: TripDestination): Int {
            return when (dest) {
                MONACO -> R.string.monaco
                BORDEAUX -> R.string.bordeaux
                LYON -> R.string.lyon
            }
        }

        fun getTrip(trip: TripDestination): String {
            return when (trip) {
                MONACO -> "Monaco"
                BORDEAUX -> "Bordeaux"
                LYON -> "Lyon"
            }
        }
    }
}


class TripDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTripDetailsBinding
    lateinit var currentDestination: TripDestination
    /*private val database = Firebase.database("https://unorganized-trip-default-rtdb.europe-west1.firebasedatabase.app/")
    val toulonMonacoRef = database.getReference("Toulon-Monaco")*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trip_details)
        binding = ActivityTripDetailsBinding.inflate(layoutInflater)

        currentDestination = intent.getSerializableExtra(HomeActivity.DestinationCity) as? TripDestination ?: TripDestination.MONACO

        val jsonFile = getJsonDataFromAsset(applicationContext, "database.json")
        if (jsonFile != null) {
            Log.d("data", jsonFile)
        }


        // Read from the database
        /*toulonMonacoRef.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = snapshot.value
                Log.d(TAG, "Value is: " + value)
                Log.d(TAG, "Type of value is: " + value!!::class.simpleName)
                parseData(value as HashMap<String, HashMap<String, HashMap<String, String>>>)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "Failed to read value.", error.toException())
            }

        })*/
    }
    /*fun parseData(data: HashMap<String, HashMap<String, HashMap<String, String> > >){
        val list = arrayListOf<TripDetails>()
        for (city_key in data.keys) {
            for (type_key in data[city_key]!!.keys){
                for (name_key in data[city_key]?.get(type_key)!!) {
                    /*Log.d(TAG, "city_key is: " + city_key)
                    Log.d(TAG, "type_key is: " + type_key)
                    Log.d(TAG, "name_key is: " + name_key)*/
                    val tripDetails = TripDetails()
                    tripDetails.detail_name = name_key.key
                    list.add(tripDetails)
                    Log.d(TAG, "list is: " + list)
                }
            }
        }
        Log.d(TAG, "SALUT")
        binding.detailList.layoutManager = LinearLayoutManager(this)
        binding.detailList.adapter = TripDetailsAdapter(list)
    }*/


    fun getJsonDataFromAsset(context: Context, fileName: String): String? {
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

    fun parseResult(json: String) {
        val result = GsonBuilder().create().fromJson(json, RequestResult::class.java)
        val villes = result.data.firstOrNull {
            it.nom == TripDestination.getTrip(currentDestination)
        }?.villes

        villes?.let {
            binding.detailList.layoutManager = LinearLayoutManager(this)
            binding.detailList.adapter =TripDetailsAdapter(villes) {
                showDetails(it)
            }
        }
    }

    private fun showDetails(ville: Ville) {
        /*val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(SELECTED_ITEM, ville)
        startActivity(intent)*/
    }

}