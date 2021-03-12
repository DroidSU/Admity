package com.brixham.admity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val images = intArrayOf(R.drawable.bluebell,R.drawable.bluebell,R.drawable.bluebell,R.drawable.bluebell,R.drawable.bluebell,R.drawable.bluebell,R.drawable.bluebell)
    private val titles = arrayOf("Lorem Ipsum","Lorem Ipsum","Lorem Ipsum","Lorem Ipsum","Lorem Ipsum","Lorem Ipsum")
    private val details = arrayOf("Reference site about Lorem ipsum,giving information on its origin, as well as random Lipsum generator","Reference site about Lorem ipsum,giving information on its origin, as well as random Lipsum generator","Reference site about Lorem ipsum,giving information on its origin, as well as random Lipsum generator","Reference site about Lorem ipsum,giving information on its origin, as well as random Lipsum generator","Reference site about Lorem ipsum,giving information on its origin, as well as random Lipsum generator","Reference site about Lorem ipsum,giving information on its origin, as well as random Lipsum generator")
    private val times = arrayOf("23 min","23 min","23 min","23 min","23 min","23 min")


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var belliconImageView : ImageView = view.findViewById(R.id.imgBlueBell)
        var textViewTitle : TextView = view.findViewById(R.id.textView_notify_heading)
        var textViewDetails: TextView = view.findViewById(R.id.textView_notify_details)
        var textViewTime: TextView = view.findViewById(R.id.textViewNotifyTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_notification_item, parent, false)
        return ViewHolder(v)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.belliconImageView.setImageResource(images[position])
        holder.textViewTitle.text = titles[position]
        holder.textViewDetails.text = details[position]
        holder.textViewTime.text = times[position]
    }
    override fun getItemCount(): Int {
        return images.size - 1
    }
}