package com.brixham.admity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R

class MyWarningAdapter: RecyclerView.Adapter<MyWarningAdapter.ViewHolder>() {


    private val textV1 = arrayOf("11-04-2021,","11-04-2021,","11-04-2021,","11-04-2021,","11-04-2021,")
    private val textV2 = arrayOf("2:07PM","3:07PM","4:00PM","2:07PM","2:07PM")
    private val images2 = intArrayOf(
        R.drawable.ic_yellow_warning,
        R.drawable.ic_yellow_warning,
        R.drawable.ic_yellow_warning,
        R.drawable.ic_yellow_warning,
        R.drawable.ic_yellow_warning,)
    private val textV3 = arrayOf("Warning 1","Warning 2","Warning 3","Warning 4","Warning 5")
    private val textV4 = arrayOf("Lorem ipsum, or lipsum as it is sometines knows...","Lorem ipsum, or lipsum as it is sometines knows...","Lorem ipsum, or lipsum as it is sometines knows...","Lorem ipsum, or lipsum as it is sometines knows...","Lorem ipsum, or lipsum as it is sometines knows...")


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textViewWarningDate: TextView = view.findViewById(R.id.my_warning_date)
        var textViewWarningTime: TextView = view.findViewById(R.id.my_warning_time)
        var displayWarningImageView : ImageView = view.findViewById(R.id.my_warning_img)
        var textViewWarningTitle: TextView = view.findViewById(R.id.my_warning_title)
        var textViewWarningDes: TextView = view.findViewById(R.id.my_warning_des)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyWarningAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.my_warning_layout_list, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: MyWarningAdapter.ViewHolder, position: Int) {
        holder.textViewWarningDate.text = textV1[position]
        holder.textViewWarningTime.text = textV2[position]
        holder.displayWarningImageView.setImageResource(images2[position])
        holder.textViewWarningTitle.text = textV3[position]
        holder.textViewWarningDes.text = textV4[position]
    }
    override fun getItemCount(): Int {
        return textV1.size
    }



}