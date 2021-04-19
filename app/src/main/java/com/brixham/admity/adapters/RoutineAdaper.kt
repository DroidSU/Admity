package com.brixham.admity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.views.RoutineActivity

class RoutineAdaper: RecyclerView.Adapter<RoutineAdaper.ViewHolder>() {

    private val images1 = intArrayOf(
        R.drawable.corner_image,
        R.drawable.corner_img2,
        R.drawable.corner_img3,
        R.drawable.corner_img4,
        R.drawable.corner_img1,)
    private val textV1 = arrayOf("MATH","ENG","BENG","COM","SCI")
    private val textV2 = arrayOf("Math","English","Bengali","Computer","Science")
    private val textV3 = arrayOf("1:00PM-2:00PM","12:00PM-1:00PM","11:00AM-12:00PM","4:00PM-5:00PM","3:00PM-4:00PM")
    private val textV4 = arrayOf("Deepak Sen","Rita Dey","Md Kabir","Rupak Das","Biswajit Dolui")


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var displayRoutineLinearLayout : LinearLayout = view.findViewById(R.id.ll_color)
        var textViewSubjectName: TextView = view.findViewById(R.id.routine_subject)
        var textViewSubName: TextView = view.findViewById(R.id.routine_sub)
        var textViewTime: TextView = view.findViewById(R.id.routine_time)
        var textViewTeacher: TextView = view.findViewById(R.id.routine_teacher)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoutineAdaper.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.routine_list, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: RoutineAdaper.ViewHolder, position: Int) {
        holder.textViewSubjectName.text = textV1[position]
        holder.textViewSubName.text = textV2[position]
        holder.textViewTime.text = textV3[position]
        holder.textViewTeacher.text = textV4[position]
    }
    override fun getItemCount(): Int {
        return textV1.size
    }



}