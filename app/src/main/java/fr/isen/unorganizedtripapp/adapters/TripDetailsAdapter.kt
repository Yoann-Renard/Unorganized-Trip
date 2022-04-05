package fr.isen.unorganizedtripapp.adapters

import android.content.ContentValues
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.isen.unorganizedtripapp.databinding.CellTripDetailsBinding
import com.squareup.picasso.Picasso;
import fr.isen.unorganizedtripapp.network.TripDetails
import fr.isen.unorganizedtripapp.network.Ville
import org.json.JSONArray
import org.json.JSONObject

class TripDetailsAdapter (private val loc: List<Ville>, val cityClickListener: (Ville) -> Unit): RecyclerView.Adapter<TripDetailsAdapter.TripDetailsViewHolder>() {
    lateinit var context: Context

    class TripDetailsViewHolder(binding: CellTripDetailsBinding): RecyclerView.ViewHolder(binding.root){
        val name: TextView = binding.detailName
        val time: TextView = binding.detailTime
        val image: ImageView = binding.detailImg
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripDetailsViewHolder {
        context = parent.context
        return TripDetailsViewHolder(CellTripDetailsBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: TripDetailsViewHolder, position: Int) {
        val locItem = loc[position]
        /*Log.d(ContentValues.TAG, "detail_name is: " + locItem.detail_name)
        holder.name.text = locItem.detail_name
        holder.time.text = locItem.detail_time
        Picasso.get()
            .load(locItem.detail_img_url)
            .into(holder.image)*/
    }

    override fun getItemCount(): Int {
        return loc.count()
    }
}