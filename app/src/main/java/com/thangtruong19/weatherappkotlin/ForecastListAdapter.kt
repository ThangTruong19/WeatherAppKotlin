package com.thangtruong19.weatherappkotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import com.thangtruong19.weatherappkotlin.domain.model.DomainForecast
import com.thangtruong19.weatherappkotlin.domain.model.ForecastList
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_forecast.*
import kotlinx.android.synthetic.main.item_forecast.view.*

class ForecastListAdapter(val forecastList: ForecastList,val itemClick: (DomainForecast) -> Unit) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>(){
    override fun getItemCount(): Int {
        return forecastList.size()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_forecast,parent,false)
        return ViewHolder(view,itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(forecastList[position]){
            holder.bindForecast(this)
        }
    }

    class ViewHolder(val view: View,val itemClick:(DomainForecast) -> Unit) :RecyclerView.ViewHolder(view){

        fun bindForecast(forecast: DomainForecast){
            with(forecast){
                Picasso.with(itemView.context).load(iconUrl).into(itemView.iconView)
                itemView.dateView.text = date
                itemView.descriptionView.text = description
                itemView.maxTemperatureView.text = "${high}º"
                itemView.minTemperatureView.text = "${low}º"
                itemView.setOnClickListener { itemClick(this) }
            }
        }

    }


}