package com.brixham.admity.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.models.HolidayResponseData
import com.brixham.admity.models.HolidayResponseModel
import com.brixham.admity.viewmodels.HolidayViewModel

class HolidayAdapter(private val context: Context, private val holidayResponseList: List<HolidayResponseData>): RecyclerView.Adapter<HolidayAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var textViewHolidayId: TextView = view.findViewById(R.id.textHoliday_Id)
        var textViewHolidayTitle: TextView = view.findViewById(R.id.textHoliday_title)
        var textViewDate: TextView = view.findViewById(R.id.textView_holiday_date)
        var textViewDescription: TextView = view.findViewById(R.id.textView_HolidayDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolidayAdapter.ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.holiday_list, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: HolidayAdapter.ViewHolder, position: Int) {
        val dataModel = holidayResponseList[position]

        holder.textViewHolidayId.text = dataModel.pk_holidayId.toString()
        holder.textViewHolidayTitle.text = dataModel.holiday_Title
        holder.textViewDate.text = dataModel.date
        holder.textViewDescription.text = dataModel.holiday_Des
    }
    override fun getItemCount(): Int {
        return holidayResponseList.size
    }


}