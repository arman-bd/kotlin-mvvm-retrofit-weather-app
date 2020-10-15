package mvvm.kotlin.weather.Retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import mvvm.kotlin.weather.Serializeable.WeatherLocation
import mvvm.kotlin.weather.Serializeable.WeatherModel
import retrofit2.http.Query

interface MetaWeather {

    @GET("location/search/")
    fun getLocation(@Query("query") query: String): Call<List<WeatherLocation>>

    @GET("location/{woeid}/")
    fun getWeather(@Path("woeid") woeid: Int): Call<WeatherModel>

}

