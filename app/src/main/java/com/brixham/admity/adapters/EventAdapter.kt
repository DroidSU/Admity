package com.brixham.admity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R

class EventAdapter: RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    private val images1 = intArrayOf(
        R.drawable.happy_womens_day,
        R.drawable.happy_womens_day,
        R.drawable.happy_womens_day,
        R.drawable.happy_womens_day,
        R.drawable.happy_womens_day,)
    private val textV1 = arrayOf("Event Name 1","Event Name 2","Event Name 3","Event Name 4","Event Name 5")
    private val textV2 = arrayOf("In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content. Lorem ipsum may be used as a placeholder before final copy is available.","In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content. Lorem ipsum may be used as a placeholder before final copy is available.","In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content. Lorem ipsum may be used as a placeholder before final copy is available.","In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content. Lorem ipsum may be used as a placeholder before final copy is available.","In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content. Lorem ipsum may be used as a placeholder before final copy is available.")
    private val images2 = intArrayOf(
        R.drawable.holiday_time_icon,
        R.drawable.holiday_time_icon,
        R.drawable.holiday_time_icon,
        R.drawable.holiday_time_icon,
        R.drawable.holiday_time_icon,)
    private val textV3 = arrayOf("23 Aug, 2021 Mon","25 Aug, 2021 Wed","27 Aug, 2021 Fri","29 Aug, 2021 Sun","31 Aug, 2021 Tue")



    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var displayEventImageView : ImageView = view.findViewById(R.id.event_circleImg)
        var textViewEventName: TextView = view.findViewById(R.id.textEvent_Name)
        var textViewEventDes: TextView = view.findViewById(R.id.textEvent_des)
        var displayEventImageViewTime : ImageView = view.findViewById(R.id.event_time_imageview)
        var textViewEventDate: TextView = view.findViewById(R.id.event_date)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.event_layout_list, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: EventAdapter.ViewHolder, position: Int) {
        holder.displayEventImageView.setImageResource(images1[position])
        holder.textViewEventName.text = textV1[position]
        holder.textViewEventDes.text = textV2[position]
        holder.displayEventImageViewTime.setImageResource(images2[position])
        holder.textViewEventDate.text = textV3[position]
    }
    override fun getItemCount(): Int {
        return images1.size - 1
    }



}