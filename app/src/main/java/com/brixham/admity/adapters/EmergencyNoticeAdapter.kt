package com.brixham.admity.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R


class EmergencyNoticeAdapter: RecyclerView.Adapter<EmergencyNoticeAdapter.ViewHolder>() {

    private val textV1 = arrayOf("Today Notice 1","Today Notice 2","Today Notice 3","Today Notice 4","Today Notice 5")
    private val textV2 = arrayOf("11:00 AM March 09,2021","11:00 AM March 09,2021","11:00 AM March 09,2021","11:00 AM March 09,2021","11:00 AM March 09,2021")
    private val textV3 = arrayOf("Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, grapic or web designs and when an unknown printer took a galley of type and scrambled it to make a type specimen book","Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, grapic or web designs and when an unknown printer took a galley of type and scrambled it to make a type specimen book","Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, grapic or web designs and when an unknown printer took a galley of type and scrambled it to make a type specimen book","Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, grapic or web designs and when an unknown printer took a galley of type and scrambled it to make a type specimen book","Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, grapic or web designs and when an unknown printer took a galley of type and scrambled it to make a type specimen book")
    private val images2 = intArrayOf(
        R.drawable.ic_download,
        R.drawable.ic_download,
        R.drawable.ic_download,
        R.drawable.ic_download,
        R.drawable.ic_download,)

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var textViewTitle: TextView = view.findViewById(R.id.emergency_notice_title)
        var textViewDate: TextView = view.findViewById(R.id.emergency_notice_date_time)
        var textViewNoticeDetails: TextView = view.findViewById(R.id.emergency_notice_details)
        var displayDownloadImageView : ImageView = view.findViewById(R.id.emergency_notice_download)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmergencyNoticeAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.emergency_notice_layout, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: EmergencyNoticeAdapter.ViewHolder, position: Int) {
        holder.textViewTitle.text = textV1[position]
        holder.textViewDate.text = textV2[position]
        holder.textViewNoticeDetails.text = textV3[position]
        holder.displayDownloadImageView.setImageResource(images2[position])
    }
    override fun getItemCount(): Int {
        return textV1.size
    }
}