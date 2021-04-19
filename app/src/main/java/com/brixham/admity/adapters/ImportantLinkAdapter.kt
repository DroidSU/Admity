package com.brixham.admity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R

class ImportantLinkAdapter: RecyclerView.Adapter<ImportantLinkAdapter.ViewHolder>() {


    private val textV1 = arrayOf("11-04-2020, 2:07PM to 11-05-2020, 2:07PM","11-04-2020, 2:07PM to 11-05-2020, 2:07PM","11-04-2020, 2:07PM to 11-05-2020, 2:07PM","11-04-2020, 2:07PM to 11-05-2020, 2:07PM","11-04-2020, 2:07PM to 11-05-2020, 2:07PM")
    private val textV2 = arrayOf("Link Title 1","Link Title 2","Link Title 3","Link Title 4","Link Title 5")
    private val textV3 = arrayOf("https://login.admity.in/Student_Panel/important_links.aspx","https://login.admity.in/Student_Panel/important_links.aspx","https://login.admity.in/Student_Panel/important_links.aspx","https://login.admity.in/Student_Panel/important_links.aspx","https://login.admity.in/Student_Panel/important_links.aspx")
    private val textV4 = arrayOf("Lorem ipsum, or lipsum as it is sometines knows...,Curabitur at venenatis risus, sit amet rhoncus orci","Lorem ipsum, or lipsum as it is sometines knows...,Curabitur at venenatis risus, sit amet rhoncus orci","Lorem ipsum, or lipsum as it is sometines knows...,Curabitur at venenatis risus, sit amet rhoncus orci","Lorem ipsum, or lipsum as it is sometines knows...,Curabitur at venenatis risus, sit amet rhoncus orci","Lorem ipsum, or lipsum as it is sometines knows...,Curabitur at venenatis risus, sit amet rhoncus orci")


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textViewImportantLinkDateTime: TextView = view.findViewById(R.id.important_link_date_time)
        var textViewImportantLinkTitle: TextView = view.findViewById(R.id.important_link_title)
        var textViewImportantLinkUrl: TextView = view.findViewById(R.id.important_link_url)
        var textViewImportantLinkDes: TextView = view.findViewById(R.id.important_link_des)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImportantLinkAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.important_link_layout_list, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: ImportantLinkAdapter.ViewHolder, position: Int) {
        holder.textViewImportantLinkDateTime.text = textV1[position]
        holder.textViewImportantLinkTitle.text = textV2[position]
        holder.textViewImportantLinkUrl.text = textV3[position]
        holder.textViewImportantLinkDes.text = textV4[position]

    }
    override fun getItemCount(): Int {
        return textV1.size
    }



}