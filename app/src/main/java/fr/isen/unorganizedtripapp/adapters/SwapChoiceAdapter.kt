package fr.isen.unorganizedtripapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.isen.unorganizedtripapp.databinding.CellSwapChoiceBinding

class SwapChoiceAdapter (/*private val choice: ArrayList<SwapChoice>*/): RecyclerView.Adapter<SwapChoiceAdapter.SwapChoiceViewHolder>() {
    lateinit var context: Context

    class SwapChoiceViewHolder(binding: CellSwapChoiceBinding): RecyclerView.ViewHolder(binding.root) {
        val name: TextView = binding.swapName
        val img: ImageView = binding.swapImage
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SwapChoiceViewHolder {
        context = parent.context
        return SwapChoiceViewHolder(CellSwapChoiceBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: SwapChoiceViewHolder, position: Int) {
        /*val chosenItem = choice[position]

        holder.name.text = chosenItem.detail_name
        Picasso
            .get()
            .load(chosenItem.detail_img_url)
            .into(holder.img)*/
    }

    override fun getItemCount(): Int {
        return 0 //choice.count()
    }
}