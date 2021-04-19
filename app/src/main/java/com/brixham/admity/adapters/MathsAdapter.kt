package com.brixham.admity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R

class MathsAdapter: RecyclerView.Adapter<MathsAdapter.ViewHolder>() {

    private val textV1 = arrayOf("Week 1","Week 1","Week 2","Week 2","Week 1")
    private val textV2 = arrayOf("15 March - 20 March","15 March - 20 March","15 March - 20 March","15 March - 20 March","15 March - 20 March")
    private val textV3 = arrayOf("Chapter 1","Chapter 2","Chapter 3","Chapter 4","Chapter 5")
    private val images1 = intArrayOf(
        R.drawable.ic_download,
        R.drawable.ic_download,
        R.drawable.ic_download,
        R.drawable.ic_download,
        R.drawable.ic_download,)
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var textViewMathWeek: TextView = view.findViewById(R.id.syllabus_week)
        var textViewMathTime: TextView = view.findViewById(R.id.syllabus_time)
        var textViewMathChapter: TextView = view.findViewById(R.id.syllabus_chapter)
        var imgMathDownload: ImageView = view.findViewById(R.id.syllabus_downloadImg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MathsAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.math_layout_list, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: MathsAdapter.ViewHolder, position: Int) {
        holder.textViewMathWeek.text = textV1[position]
        holder.textViewMathTime.text = textV2[position]
        holder.textViewMathChapter.text = textV3[position]
        holder.imgMathDownload.setImageResource(images1[position])

    }
    override fun getItemCount(): Int {
        return textV1.size
    }



}