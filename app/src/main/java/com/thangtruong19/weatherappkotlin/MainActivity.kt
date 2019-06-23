package com.thangtruong19.weatherappkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.thangtruong19.weatherappkotlin.data.ForecastRequest
import com.thangtruong19.weatherappkotlin.domain.RequestForecastCommand
import com.thangtruong19.weatherappkotlin.domain.model.DomainForecast
import com.thangtruong19.weatherappkotlin.domain.model.ForecastList
import org.jetbrains.anko.async
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecastList = findViewById<RecyclerView>(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)

        async {
            val result:ForecastList = RequestForecastCommand("94043").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result,object :ForecastListAdapter.OnItemClickListener{
                    override fun invoke(forecast: DomainForecast) {
                        toast(forecast.description)
                    }
                })
            }
        }
    }
}
