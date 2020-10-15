package mvvm.kotlin.weather.Serializeable

import com.google.gson.annotations.SerializedName

data class WeatherModel (
    @SerializedName("consolidated_weather") val consolidated_weather : List<Consolidated_weather>,
    @SerializedName("time") val time : String,
    @SerializedName("sun_rise") val sun_rise : String,
    @SerializedName("sun_set") val sun_set : String,
    @SerializedName("timezone_name") val timezone_name : String,
    @SerializedName("parent") val parent : Parent,
    @SerializedName("sources") val sources : List<Sources>,
    @SerializedName("title") val title : String,
    @SerializedName("location_type") val location_type : String,
    @SerializedName("woeid") val woeid : Int,
    @SerializedName("latt_long") val latt_long : String,
    @SerializedName("timezone") val timezone : String
)

data class Parent (
    @SerializedName("title") val title : String,
    @SerializedName("location_type") val location_type : String,
    @SerializedName("woeid") val woeid : Int,
    @SerializedName("latt_long") val latt_long : String
)

data class Consolidated_weather (
    @SerializedName("id") val id : Double,
    @SerializedName("weather_state_name") val weather_state_name : String,
    @SerializedName("weather_state_abbr") val weather_state_abbr : String,
    @SerializedName("wind_direction_compass") val wind_direction_compass : String,
    @SerializedName("created") val created : String,
    @SerializedName("applicable_date") val applicable_date : String,
    @SerializedName("min_temp") val min_temp : Double,
    @SerializedName("max_temp") val max_temp : Double,
    @SerializedName("the_temp") val the_temp : Double,
    @SerializedName("wind_speed") val wind_speed : Double,
    @SerializedName("wind_direction") val wind_direction : Double,
    @SerializedName("air_pressure") val air_pressure : Double,
    @SerializedName("humidity") val humidity : Int,
    @SerializedName("visibility") val visibility : Double,
    @SerializedName("predictability") val predictability : Int
)

data class Sources (
    @SerializedName("title") val title : String,
    @SerializedName("slug") val slug : String,
    @SerializedName("url") val url : String,
    @SerializedName("crawl_rate") val crawl_rate : Int
)

data class WeatherLocation (
    @SerializedName("title") val title : String,
    @SerializedName("location_type") val location_type : String,
    @SerializedName("woeid") val woeid : Int,
    @SerializedName("latt_long") val latt_long : String
)