package com.thangtruong19.weatherappkotlin.domain.model

data class ForecastList(val city:String,val country:String,val dailyForecast:List<DomainForecast>)

data class DomainForecast(val date:String,val description:String,val high:Int,val low:Int)