package com.thangtruong19.weatherappkotlin.domain

import com.thangtruong19.weatherappkotlin.data.ForecastRequest
import com.thangtruong19.weatherappkotlin.domain.mapper.ForecastDataMapper
import com.thangtruong19.weatherappkotlin.domain.model.ForecastList

class RequestForecastCommand(val zipCode:String): Command<ForecastList>{
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}