package com.brixham.admity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R

class LeaveAdapter: RecyclerView.Adapter<LeaveAdapter.ViewHolder>() {

    private val textV1 = arrayOf("Late In,","Early Out,","Late In,","Late In,","Early Out,")
    private val textV2 = arrayOf("11-04-2021","11-04-2021","11-04-2021","11-04-2021","11-04-2021")
    private val textV3 = arrayOf("Refuse","Approved","Refuse","Refuse","Approved")
    private val textV4 = arrayOf("Lorem ipsum, or lipsum as it is sometimes knowns","Lorem ipsum, or lipsum as it is sometimes knowns","Lorem ipsum, or lipsum as it is sometimes knowns","Lorem ipsum, or lipsum as it is sometimes knowns","Lorem ipsum, or lipsum as it is sometimes knowns")
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var textViewLeaveType: TextView = view.findViewById(R.id.leave_type)
        var textViewLeaveDate: TextView = view.findViewById(R.id.leave_date)
        var textViewLeaveStatus: TextView = view.findViewById(R.id.leave_status)
        var textViewLeaveDetails: TextView = view.findViewById(R.id.leave_purpose)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaveAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.leave_layout_list, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: LeaveAdapter.ViewHolder, position: Int) {
        holder.textViewLeaveType.text = textV1[position]
        holder.textViewLeaveDate.text = textV2[position]
        holder.textViewLeaveStatus.text = textV3[position]
        holder.textViewLeaveDetails.text = textV4[position]

    }
    override fun getItemCount(): Int {
        return textV1.size
    }



}