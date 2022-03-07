package fr.isen.unorganizedtripapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.isen.unorganizedtripapp.databinding.CellTripDetailsBinding
import com.squareup.picasso.Picasso;
import fr.isen.unorganizedtripapp.network.TripDetails
import org.json.JSONArray
import org.json.JSONObject

class TripDetailsAdapter (private val loc: List<TripDetails> ): RecyclerView.Adapter<TripDetailsAdapter.TripDetailViewHolder>() {
    lateinit var context: Context

    class TripDetailViewHolder(binding: CellTripDetailsBinding): RecyclerView.ViewHolder(binding.root){
        val name: TextView = binding.detailName
        val time: TextView = binding.detailTime
        val image: ImageView = binding.detailImg
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripDetailViewHolder {
        context = parent.context
        return TripDetailViewHolder(CellTripDetailsBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: TripDetailViewHolder, position: Int) {
        val locItem = loc[position]
        holder.name.text = locItem.detail_name
        holder.time.text = locItem.detail_time
        Picasso.get()
            .load(locItem.detail_img_url)
            .into(holder.image)
    }

    override fun getItemCount(): Int {
        return loc.count()
    }
}