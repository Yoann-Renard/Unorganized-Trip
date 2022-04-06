package fr.isen.unorganizedtripapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import fr.isen.unorganizedtripapp.Data.Markers
import fr.isen.unorganizedtripapp.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        /*
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        */
        mMap.addMarker(MarkerOptions().position(LatLng(43.12235632952049, 5.938399225476811)).title("ISEN Yncrea Méditerranée"))
        mMap.addMarker(MarkerOptions().position(LatLng(43.73934414660515, 7.425547411308378)).title("Monaco"))
        val zoomLevel = 8.0f
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(43.12235632952049, 5.938399225476811), zoomLevel))
        val currentBudget: TripBudget = intent.getSerializableExtra(HomeActivity.Budget) as? TripBudget ?: TripBudget.MOYEN
        val makers = Markers(currentBudget)
        makers.list.forEach{ (name, floats) ->
            run {
                mMap.addMarker(
                    MarkerOptions().position(LatLng(floats[0].toDouble(), floats[1].toDouble())).title(name)
                )
            }
        }

    }


}