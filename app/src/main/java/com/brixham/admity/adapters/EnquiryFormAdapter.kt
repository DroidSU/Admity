package com.brixham.admity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R

class EnquiryFormAdapter : RecyclerView.Adapter<EnquiryFormAdapter.ViewHolder>() {

    private val date = arrayOf("11-04-2020","21-04-2020","15-10-2020","05-11-2020","12-12-2020","31-12-2020","11-01-2021","21-01-2021")
    private val times = arrayOf("2:07PM","2:10PM","2:10PM","2:10PM","2:07PM","2:07PM","2:07PM","2:07PM")
    private val images = intArrayOf(
        R.drawable.ic_enquiry,
        R.drawable.ic_enquiry,
        R.drawable.ic_enquiry,
        R.drawable.ic_enquiry,
        R.drawable.ic_enquiry,
        R.drawable.ic_enquiry,
        R.drawable.ic_enquiry,
        R.drawable.ic_enquiry,)
    private val type = arrayOf("Enquire Type 1","Enquire Type 2","Enquire Type 3","Enquire Type 4","Enquire Type 5","Enquire Type 6","Enquire Type 7")
    private val title = arrayOf("School Reply","School Reply","School Reply","School Reply","School Reply","School Reply","School Reply","School Reply")
    private val reply = arrayOf("Lorem ipsum, or lipsum as it is sometmes known,","Reference site about Lorem ipsum,giving information on its origin, as well as random Lipsum generator","Lorem ipsum, or lipsum as it is sometmes known,","Reference site about Lorem ipsum,giving information on its origin, as well as random Lipsum generator","Reference site about Lorem ipsum,giving information on its origin, as well as random Lipsum generator","Reference site about Lorem ipsum,giving information on its origin, as well as random Lipsum generator","Lorem ipsum, or lipsum as it is sometmes known,","Lorem ipsum, or lipsum as it is sometmes known,")



    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var enquiryImg : ImageView = view.findViewById(R.id.enquiry_img)
        var textViewDate : TextView = view.findViewById(R.id.enquiry_date)
        var textViewTime : TextView = view.findViewById(R.id.enquiry_time)
        var textViewType : TextView = view.findViewById(R.id.enquiryType)
        var textViewTitle : TextView = view.findViewById(R.id.enquirySchool_reply)
        var textViewReply : TextView = view.findViewById(R.id.enquirySchool_reply_des)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EnquiryFormAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.enquiry_layout_list, parent, false)
        return ViewHolder(v)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewDate.text = date[position]
        holder.textViewTime.text = times[position]
        holder.enquiryImg.setImageResource(images[position])
        holder.textViewType.text = type[position]
        holder.textViewTitle.text = title[position]
        holder.textViewReply.text = reply[position]

    }
    override fun getItemCount(): Int {
        return date.size - 1
    }
}