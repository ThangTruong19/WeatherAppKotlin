package com.thangtruong19.weatherappkotlin

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.thangtruong19.weatherappkotlin.domain.model.ForecastList

class ForecastListAdapter(val forecastList: ForecastList) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>(){
    override fun getItemCount(): Int {
        return forecastList.size()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(forecastList[position]){
            holder.textView.text = "$date - $description - $high/$low"
        }
    }

    class ViewHolder(val textView:TextView) :RecyclerView.ViewHolder(textView)
}