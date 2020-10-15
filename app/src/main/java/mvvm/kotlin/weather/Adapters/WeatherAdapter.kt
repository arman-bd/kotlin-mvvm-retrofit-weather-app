package mvvm.kotlin.weather.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mvvm.kotlin.weather.Serializeable.Consolidated_weather
import mvvm.kotlin.weather.R
import mvvm.kotlin.weather.databinding.ItemWeatherBinding
import java.text.DecimalFormat

class WeatherAdapter(private val data: List<Consolidated_weather>) : RecyclerView.Adapter<WeatherAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: ItemWeatherBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemWeatherBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val df = DecimalFormat()
        df.setMaximumFractionDigits(2)

        holder.binding.textWeatherState.text = data.get(position).weather_state_name
        holder.binding.textDate.text = data.get(position).applicable_date

        holder.binding.txtAverageValue.text = df.format(data.get(position).the_temp).toString() + "°"
        holder.binding.txtMinimumValue.text = df.format(data.get(position).min_temp).toString() + "°"
        holder.binding.txtMaximumValue.text = df.format(data.get(position).max_temp).toString() + "°"

        holder.binding.textAirPressureValue.text = df.format(data.get(position).air_pressure).toString() + " mbar"
        holder.binding.textWindDirectionValue.text = data.get(position).wind_direction_compass
        holder.binding.textWindSpeedValue.text = df.format(data.get(position).wind_speed).toString() + " mph"
        holder.binding.textHumidityValue.text = df.format(data.get(position).humidity).toString() + "%"
        holder.binding.textVisibilityValue.text = df.format(data.get(position).visibility).toString() + " miles"
        holder.binding.textAccuracyValue.text = data.get(position).predictability.toString() + "%";

        if(data.get(position).weather_state_abbr.equals("c")){holder.binding.iconWeather.setImageResource(R.drawable.weather_c)}
        if(data.get(position).weather_state_abbr.equals("h")){holder.binding.iconWeather.setImageResource(R.drawable.weather_h)}
        if(data.get(position).weather_state_abbr.equals("hc")){holder.binding.iconWeather.setImageResource(R.drawable.weather_hc)}
        if(data.get(position).weather_state_abbr.equals("hr")){holder.binding.iconWeather.setImageResource(R.drawable.weather_hr)}
        if(data.get(position).weather_state_abbr.equals("lc")){holder.binding.iconWeather.setImageResource(R.drawable.weather_lc)}
        if(data.get(position).weather_state_abbr.equals("lr")){holder.binding.iconWeather.setImageResource(R.drawable.weather_lr)}
        if(data.get(position).weather_state_abbr.equals("s")){holder.binding.iconWeather.setImageResource(R.drawable.weather_s)}
        if(data.get(position).weather_state_abbr.equals("sl")){holder.binding.iconWeather.setImageResource(R.drawable.weather_sl)}
        if(data.get(position).weather_state_abbr.equals("sn")){holder.binding.iconWeather.setImageResource(R.drawable.weather_sn)}
        if(data.get(position).weather_state_abbr.equals("t")){holder.binding.iconWeather.setImageResource(R.drawable.weather_t)}
    }

    override fun getItemCount(): Int = data.size
}