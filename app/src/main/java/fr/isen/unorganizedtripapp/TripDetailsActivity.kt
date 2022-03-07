package fr.isen.unorganizedtripapp

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import fr.isen.unorganizedtripapp.network.TripDetails
import kotlin.reflect.typeOf

class TripDetailsActivity : AppCompatActivity() {
    val database = Firebase.database("https://unorganized-trip-default-rtdb.europe-west1.firebasedatabase.app/")
    val toulonMonacoRef = database.getReference("Toulon-Monaco")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trip_details)


        // Read from the database
        toulonMonacoRef.addValueEventListener(object: ValueEventListener {

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

        })


    }
    fun parseData(data: HashMap<String, HashMap<String, HashMap<String, String> > >){
        val list = ArrayList<TripDetails>()
        for (city_key in data.keys) {
            for (type_key in data[city_key]!!.keys){
                for (name_key in data[city_key]?.get(type_key)!!.keys) {
                    /*Log.d(TAG, "city_key is: " + city_key)
                    Log.d(TAG, "type_key is: " + type_key)
                    Log.d(TAG, "name_key is: " + name_key)*/
                    val TD = TripDetails()
                    TD.detail_name = name_key
                    //TD.detail_img_url = data[city_key]?.get(type_key)?.get(name_key)?.get("img").toString()
                }
            }
        }
    }
}