package com.brixham.admity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R

class MathPaperAdapter: RecyclerView.Adapter<MathPaperAdapter.ViewHolder>() {

    private val textV1 = arrayOf("Q.1.","Q.2.","Q.3.","Q.4.","Q.5.")
    private val textV2 = arrayOf("Lorem ipsum, or lipsum as?","Lorem ipsum, or lipsum as?","Lorem ipsum, or lipsum as?","Lorem ipsum, or lipsum as?","Lorem ipsum, or lipsum as?")
    private val textV3 = arrayOf("Lorem ipsum, or lipsum as it is sometimes knowns, is dummy text used in laying out print, graphic or web design. The passage is attributed to an unknown typeseeter in.","Lorem ipsum, or lipsum as it is sometimes knowns, is dummy text used in laying out print, graphic or web design. The passage is attributed to an unknown typeseeter in.","Lorem ipsum, or lipsum as it is sometimes knowns, is dummy text used in laying out print, graphic or web design. The passage is attributed to an unknown typeseeter in.","Lorem ipsum, or lipsum as it is sometimes knowns, is dummy text used in laying out print, graphic or web design. The passage is attributed to an unknown typeseeter in.","Lorem ipsum, or lipsum as it is sometimes knowns, is dummy text used in laying out print, graphic or web design. The passage is attributed to an unknown typeseeter in.")

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var textViewQuesNo: TextView = view.findViewById(R.id.math_paper_quesNo)
        var textViewQues: TextView = view.findViewById(R.id.math_paper_ques)
        var textViewAns: TextView = view.findViewById(R.id.math_paper_ans)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MathPaperAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.math_paper_layout, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: MathPaperAdapter.ViewHolder, position: Int) {
        holder.textViewQuesNo.text = textV1[position]
        holder.textViewQues.text = textV2[position]
        holder.textViewAns.text = textV3[position]


    }
    override fun getItemCount(): Int {
        return textV1.size
    }



}