package com.thangtruong19.weatherappkotlin.data

data class ForecastResult(val city: City,val list:List<Forecast>)

data class City(val id:Long,val name:String,val coords:Coordinates,val country:String,val population:Int)

data class Coordinates(val lat:Float,val lon:Float)

data class Forecast(val dt:Long,val temp:Temperature,val pressure:Float,val humidlity:Int,
                    val weather:List<Weather>,val speed:Float,val deg:Int,val clouds:Int)

data class Temperature(val day:Float,val min:Float,val max:Float,val night:Float,val eve:Float,val mon:Float)

data class Weather(val id: Long,val main:String,val description:String,val icon:String)