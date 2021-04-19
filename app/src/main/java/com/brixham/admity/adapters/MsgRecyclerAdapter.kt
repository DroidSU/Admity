package com.brixham.admity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R


class MsgRecyclerAdapter : RecyclerView.Adapter<MsgRecyclerAdapter.ViewHolder>(){

    private val images = intArrayOf(R.drawable.imgdp,R.drawable.imgdp,R.drawable.imgdp,R.drawable.imgdp,R.drawable.imgdp,R.drawable.imgdp,R.drawable.imgdp)
    private val textV1 = arrayOf("Kate Perry","Rohit Setty","Rohit Shetty","Lorem Ipsum","Rohit Setty","Lorem Ipsum")
    private val textV2 = arrayOf("Reference site about Lorem ipsum,giving information on its origin, as well as random Lipsum generator","Reference site about Lorem ipsum,giving information on its origin, as well as random Lipsum generator","Reference site about Lorem ipsum,giving information on its origin, as well as random Lipsum generator","Reference site about Lorem ipsum,giving information on its origin, as well as random Lipsum generator","Reference site about Lorem ipsum,giving information on its origin, as well as random Lipsum generator","Reference site about Lorem ipsum,giving information on its origin, as well as random Lipsum generator")
    private val textV3 = arrayOf("1"," "," "," "," "," ")
    private val textV4 = arrayOf("23 min","27 min","33 min","37 min","40 min","45 min")


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var displayImageView : ImageView = view.findViewById(R.id.circleImg_dp)
        var textViewFullName: TextView = view.findViewById(R.id.textMsgFullName)
        var textViewTxtDetails: TextView = view.findViewById(R.id.textMsgDetails)
        var textViewTxtNumber: TextView = view.findViewById(R.id.txtMsgNumber)
        var textViewTxtTime: TextView = view.findViewById(R.id.textMsgTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recyclerlist_messages, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.displayImageView.setImageResource(images[position])
        holder.textViewFullName.text = textV1[position]
        holder.textViewTxtDetails.text = textV2[position]
        holder.textViewTxtNumber.text = textV3[position]
        holder.textViewTxtTime.text = textV4[position]
        if (position==0){
            holder.textViewTxtNumber.visibility = View.VISIBLE
        }
    }

    override fun getItemCount(): Int {
        return images.size - 1
    }




}