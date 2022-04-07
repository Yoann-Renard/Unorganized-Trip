package fr.isen.unorganizedtripapp.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.isen.unorganizedtripapp.databinding.CellTripDetailsBinding
import fr.isen.unorganizedtripapp.data.Stop

class TripDetailsAdapter (private val listStop: List<Stop>, private val stopClickListener: (Stop) -> Unit): RecyclerView.Adapter<TripDetailsAdapter.TripDetailsViewHolder>() {
    lateinit var context: Context

    class TripDetailsViewHolder(binding: CellTripDetailsBinding): RecyclerView.ViewHolder(binding.root){
        val stopName: TextView = binding.detailName
        val stopCity: TextView = binding.detailCity
        val stopDesc: TextView = binding.detailDesc
        val stopImg: ImageView = binding.detailImg
        val layout: CardView = binding.root
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

        holder.layout.setOnClickListener {
            stopClickListener.invoke(stop)
        }
    }

    override fun getItemCount(): Int {
        return listStop.count()
    }
}