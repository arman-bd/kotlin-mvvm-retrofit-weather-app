package mvvm.kotlin.weather.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import mvvm.kotlin.weather.Activities.CellClickListener
import mvvm.kotlin.weather.Serializeable.WeatherLocation
import mvvm.kotlin.weather.databinding.ItemLocationBinding

class LocationAdapter(private val data: List<WeatherLocation>, private val cellClickListener: CellClickListener) : RecyclerView.Adapter<LocationAdapter.MyViewHolder>()  {

    class MyViewHolder(val binding: ItemLocationBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemLocationBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.textName.text = data.get(position).title
        holder.binding.textType.text = data.get(position).location_type
        holder.itemView.setOnClickListener {
            cellClickListener.locationOnClick(position, data.get(position).woeid)
        }
    }

    override fun getItemCount(): Int = data.size
}