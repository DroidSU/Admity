package com.brixham.admity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R

class TimeTableAdapter : RecyclerView.Adapter<TimeTableAdapter.ViewHolder>() {


    private val textV1 = arrayOf("Biology", "Physics", "Geography", "Science", "English")
    private val textV2 =
        arrayOf("Human Anatomy", "Earth Quantum", "Mason Rains", "Earth Quantum", "Earth Quantum")
    private val textV3 = arrayOf("Priya Sarkar", "Amit Gupta", "Amit Gupta", "Rita Dey", "Rita Dey")


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textViewSubName: TextView = view.findViewById(R.id.timetable_sub)
        var textViewSubTopic: TextView = view.findViewById(R.id.timetable_topic)
        var textViewSubTeacher: TextView = view.findViewById(R.id.timetable_teacher)
        var viewDot: View = view.findViewById(R.id.dot_indicator_timetable)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeTableAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.timetable_layout_list, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: TimeTableAdapter.ViewHolder, position: Int) {
        holder.textViewSubName.text = textV1[position]
        holder.textViewSubTopic.text = textV2[position]
        holder.textViewSubTeacher.text = textV3[position]
        if (position==1){
            holder.viewDot.setBackgroundResource(R.drawable.dot_enabled)
        }

    }

    override fun getItemCount(): Int {
        return textV1.size
    }


}