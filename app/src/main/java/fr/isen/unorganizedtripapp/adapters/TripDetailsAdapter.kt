package fr.isen.unorganizedtripapp.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.isen.unorganizedtripapp.databinding.CellTripDetailsBinding
import fr.isen.unorganizedtripapp.network.Stop

class TripDetailsAdapter (private val listStop: List<Stop>): RecyclerView.Adapter<TripDetailsAdapter.TripDetailsViewHolder>() {
    lateinit var context: Context

    class TripDetailsViewHolder(binding: CellTripDetailsBinding): RecyclerView.ViewHolder(binding.root){
        val stopName: TextView = binding.detailName
        val stopCity: TextView = binding.detailCity
        val stopDesc: TextView = binding.detailDesc
        val stopImg: ImageView = binding.detailImg
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripDetailsViewHolder {
        Log.d("ADAPTER", "View holder created")
        context = parent.context
        return TripDetailsViewHolder(CellTripDetailsBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: TripDetailsViewHolder, position: Int) {
        val stop = listStop[position]
        Log.d("ADAPTER", "In onBindViewHolder, stop n°$position: ${stop.name}")

        holder.stopName.text = stop.name
        holder.stopCity.text = stop.city
        holder.stopDesc.text = stop.desc
        Picasso
            .get()
            .load(stop.img)
            .into(holder.stopImg)
    }

    override fun getItemCount(): Int {
        val count = listStop.count()
        return count
    }
}