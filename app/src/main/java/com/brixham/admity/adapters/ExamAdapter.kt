package com.brixham.admity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R

class ExamAdapter: RecyclerView.Adapter<ExamAdapter.ViewHolder>() {

    private val textV1 = arrayOf("First Semester","First Semester","First Semester","First Semester","First Semester")
    private val textV2 = arrayOf("Ten(A)","Ten(B)","Nine(A)","Nine(B)","Ten(A)")
    private val textV3 = arrayOf("Bengali","English","Hindi","Maths","Science")
    private val textV4 = arrayOf("Room-20","Room-20","Room-21","Room-21","Room-22")
    private val textV5 = arrayOf("23 Aug, 2021","23 Aug, 2021","23 Aug, 2021","23 Aug, 2021","23 Aug, 2021")
    private val textV6 = arrayOf("11:00am - 1:00pm","11:00am - 1:00pm","11:00am - 1:00pm","11:00am - 1:00pm","11:00am - 1:00pm")



    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        var textViewSemesterName: TextView = view.findViewById(R.id.exam_semester)
        var textViewClass: TextView = view.findViewById(R.id.exam_class)
        var textViewSubject: TextView = view.findViewById(R.id.exam_subject)
        var textViewRoom: TextView = view.findViewById(R.id.exam_room)
        var textViewDate: TextView = view.findViewById(R.id.exam_date)
        var textViewTime: TextView = view.findViewById(R.id.exam_timeDuration)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExamAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.exam_layout_list, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: ExamAdapter.ViewHolder, position: Int) {
        holder.textViewSemesterName.text = textV1[position]
        holder.textViewClass.text = textV2[position]
        holder.textViewSubject.text = textV3[position]
        holder.textViewRoom.text = textV4[position]
        holder.textViewDate.text = textV5[position]
        holder.textViewTime.text = textV6[position]
    }
    override fun getItemCount(): Int {
        return textV1.size    }



}