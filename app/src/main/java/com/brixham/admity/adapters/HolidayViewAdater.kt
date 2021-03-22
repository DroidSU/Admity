package com.brixham.admity.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.models.HolidayResponseModel
import com.brixham.admity.views.HolidayView

class HolidayViewAdater(private var dataList: List<HolidayResponseModel>, private val context: Context) : RecyclerView.Adapter<HolidayViewAdater.ViewHolder>() {
    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        lateinit var holidayIdTextView:TextView
        lateinit var holidayNameTextView:TextView
        init {
            holidayIdTextView=itemLayoutView.findViewById(R.id.textHoliday_Id)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


}