package com.brixham.admity.adapters

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R

class MyAssignmentAdapter: RecyclerView.Adapter<MyAssignmentAdapter.ViewHolder>() {

    private val textV1 = arrayOf("Subject Name","Subject Name","Subject Name","Subject Name","Subject Name")
    private val textV2 = arrayOf("Submitted","Pending","Rejected","Submitted","Pending")
    private val textV3 = arrayOf("31-09-2021","31-09-2021","30-09-2021","30-09-2021","31-08-2021")
    private val textV4 = arrayOf("Lorem ipsum, or lipsum as it is sometimes...","Lorem ipsum, or lipsum as it is sometimes...","Lorem ipsum, or lipsum as it is sometimes...","Lorem ipsum, or lipsum as it is sometimes...","Lorem ipsum, or lipsum as it is sometimes...")
    private val textV5 = arrayOf("View","Upload","Upload","View","Upload")



    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textViewAssignmentSubName: TextView = view.findViewById(R.id.assignment_subject_name)
        var textViewAssignmentStatus: TextView = view.findViewById(R.id.assignment_status)
        var textViewAssignmentDate: TextView = view.findViewById(R.id.assignment_date)
        var textViewAssignmentDetails: TextView = view.findViewById(R.id.assignment_details)
        var textViewAssignmentButton: Button = view.findViewById(R.id.assignment_button)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAssignmentAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.assignment_layout_list, parent, false)
        return ViewHolder(v)
    }
    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: MyAssignmentAdapter.ViewHolder, position: Int) {
        holder.textViewAssignmentSubName.text = textV1[position]
        holder.textViewAssignmentStatus.text = textV2[position]
        holder.textViewAssignmentDate.text = textV3[position]
        holder.textViewAssignmentDetails.text = textV4[position]
        holder.textViewAssignmentButton.text = textV5[position]
        if (position==1){
            holder.textViewAssignmentButton.setBackgroundResource(R.drawable.red_button_shape)
            holder.textViewAssignmentStatus.setTextColor(Color.parseColor("#AF8810"))
        }else if (position==2){
            holder.textViewAssignmentButton.setBackgroundResource(R.drawable.red_button_shape)
            holder.textViewAssignmentStatus.setTextColor(Color.parseColor("#F40707"))
        }else if (position==4){
            holder.textViewAssignmentButton.setBackgroundResource(R.drawable.red_button_shape)
            holder.textViewAssignmentStatus.setTextColor(Color.parseColor("#AF8810"))
        }


    }
    override fun getItemCount(): Int {
        return textV1.size
    }



}