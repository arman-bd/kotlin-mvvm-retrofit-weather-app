package mvvm.kotlin.weather.Repository

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mvvm.kotlin.weather.Retrofit.MetaWeather
import mvvm.kotlin.weather.Retrofit.ServiceBuilder
import mvvm.kotlin.weather.Serializeable.WeatherModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherDataRepository : ViewModel() {

    private val weatherModel: MutableLiveData<WeatherModel?> = MutableLiveData()

    fun observeWeatherData(): MutableLiveData<WeatherModel?> {
        return weatherModel
    }

    fun requestWeatherData(woeid: Int) {

        val weatherDataCall: Call<WeatherModel> = myInterface.getWeather(woeid)
        weatherDataCall.enqueue(object : Callback<WeatherModel?> {
            override fun onResponse(call: Call<WeatherModel?>, response: Response<WeatherModel?>) {
                weatherModel.setValue(response.body())
            }

            override fun onFailure(call: Call<WeatherModel?>, t: Throwable) {
                weatherModel.postValue(null)
            }
        })

    }

    companion object {
        private lateinit var myInterface: MetaWeather
        private var weatherDataRepository: WeatherDataRepository? = null
        val instance: WeatherDataRepository?
            get() {
                if (weatherDataRepository == null) {
                    weatherDataRepository = WeatherDataRepository()
                }
                return weatherDataRepository
            }
    }

    init {
        myInterface = ServiceBuilder.buildService(MetaWeather::class.java)
    }
}
