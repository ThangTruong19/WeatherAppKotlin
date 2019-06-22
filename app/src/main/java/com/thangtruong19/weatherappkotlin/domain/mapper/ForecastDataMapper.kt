package com.thangtruong19.weatherappkotlin.domain.mapper

import com.thangtruong19.weatherappkotlin.data.Forecast
import com.thangtruong19.weatherappkotlin.data.ForecastResult
import com.thangtruong19.weatherappkotlin.domain.model.DomainForecast
import com.thangtruong19.weatherappkotlin.domain.model.ForecastList
import java.text.DateFormat
import java.util.*

public class ForecastDataMapper{

    fun convertFromDataModel(forecastResult: ForecastResult): ForecastList{
        return ForecastList(forecastResult.city.name,forecastResult.city.country,convertForecastListToDomain(forecastResult.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>):List<DomainForecast>{
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast):DomainForecast{
        return DomainForecast(convertDate(forecast.dt),forecast.weather[0].description,forecast.temp.max.toInt(),forecast.temp.min.toInt())
    }

    private fun convertDate(date:Long):String{
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date*1000)
    }
}