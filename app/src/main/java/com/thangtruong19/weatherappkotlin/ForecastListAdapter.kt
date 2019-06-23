package com.thangtruong19.weatherappkotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.thangtruong19.weatherappkotlin.domain.model.DomainForecast
import com.thangtruong19.weatherappkotlin.domain.model.ForecastList
import org.jetbrains.anko.find

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
        private val iconView:ImageView = view.find(R.id.icon)
        private val dateView:TextView = view.find(R.id.date)
        private val descriptionView:TextView = view.find(R.id.description)
        private val maxTempatureView:TextView = view.find(R.id.maxTemperature)
        private val minTempatureView:TextView = view.find(R.id.minTemperature)
    
        fun bindForecast(forecast: DomainForecast){
            with(forecast){
                Picasso.with(itemView.context).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTempatureView.text = "${high}º"
                minTempatureView.text = "${low}º"
                itemView.setOnClickListener { itemClick(this) }
            }
        }

    }


}