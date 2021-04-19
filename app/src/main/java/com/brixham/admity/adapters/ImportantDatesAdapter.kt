package com.brixham.admity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R

class ImportantDatesAdapter: RecyclerView.Adapter<ImportantDatesAdapter.ViewHolder>() {


    private val textV1 = arrayOf("15 Aug","20 Aug","10 Sep","22 Sep","02 Oct")
    private val textV2 = arrayOf("Important Dates 1","Important Dates 2","Important Dates 3","Important Dates 4","Important Dates 5")
    private val textV3 = arrayOf("Sunday, 15 August 2021","Sunday, 15 August 2021","Sunday, 15 August 2021","Sunday, 15 August 2021","Sunday, 15 August 2021")



    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textViewImportantDate: TextView = view.findViewById(R.id.important_dates)
        var textViewImportantDateTitle: TextView = view.findViewById(R.id.important_dates_title)
        var textViewImportantDateDay: TextView = view.findViewById(R.id.important_dates_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImportantDatesAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.important_dates_layout_list, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: ImportantDatesAdapter.ViewHolder, position: Int) {
        holder.textViewImportantDate.text = textV1[position]
        holder.textViewImportantDateTitle.text = textV2[position]
        holder.textViewImportantDateDay.text = textV3[position]



    }
    override fun getItemCount(): Int {
        return textV1.size
    }



}