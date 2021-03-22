package com.brixham.admity.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.viewmodels.HolidayViewModel

class HolidayAdapter(private val holidayViewModel: List<HolidayViewModel>, private val context: Context): RecyclerView.Adapter<HolidayAdapter.ViewHolder>() {

    private val images1 = intArrayOf(R.drawable.happy_womens_day,R.drawable.happy_womens_day,R.drawable.happy_womens_day,R.drawable.happy_womens_day,R.drawable.happy_womens_day)
    private val textV1 = arrayOf(" ","Holiday Id","Holiday Id","Holiday Id","Holiday Id")
    private val textV2 = arrayOf("Holiday Name 1","Holiday Name 2","Holiday Name 3","Holiday Name 4","Holiday Name 5")
    private val images2 = intArrayOf(R.drawable.holiday_time_icon,R.drawable.holiday_time_icon,R.drawable.holiday_time_icon,R.drawable.holiday_time_icon,R.drawable.holiday_time_icon)
    private val textV3 = arrayOf("Date","Date","Date","Date","Date")
    private val textV4 = arrayOf("8th March 2021","8th March 2021","8th March 2021","8th March 2021","8th March 2021")


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var displayHolidayImageView : ImageView = view.findViewById(R.id.holiday_cicleImg)
        var textViewHolidayId: TextView = view.findViewById(R.id.textHoliday_Id)
        var textViewHolidayName: TextView = view.findViewById(R.id.textHoliday_name)
        var displayHolidayTimeImageView : ImageView = view.findViewById(R.id.holiday_timeCircleImg)
        var textViewDate: TextView = view.findViewById(R.id.textView_Date)
        var textViewDateYear: TextView = view.findViewById(R.id.textView_dateYear)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolidayAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.holiday_list, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: HolidayAdapter.ViewHolder, position: Int) {
        val dataModel=holidayViewModel.get(position)

        holder.displayHolidayImageView.setImageResource(images1[position])
        //holder.textViewHolidayId.text = listOf(dataModel)
        holder.displayHolidayTimeImageView.setImageResource(images2[position])
        holder.textViewDate.text = textV3[position]
        holder.textViewDateYear.text = textV4[position]
    }
    override fun getItemCount(): Int {
        return holidayViewModel.size
    }


}