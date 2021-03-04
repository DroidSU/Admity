package com.brixham.admity.adaptars

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val images = intArrayOf(R.drawable.bluebell,R.drawable.bluebell,R.drawable.bluebell,R.drawable.bluebell,R.drawable.bluebell,R.drawable.bluebell,R.drawable.bluebell)
    private val textV1 = arrayOf("Lorem Ipsum","Lorem Ipsum","Lorem Ipsum","Lorem Ipsum","Lorem Ipsum","Lorem Ipsum")
    private val textV2 = arrayOf("Reference site about Lorem ipsum,giving information on its origin, as well as random Lipsum generator","Reference site about Lorem ipsum,giving information on its origin, as well as random Lipsum generator","Reference site about Lorem ipsum,giving information on its origin, as well as random Lipsum generator","Reference site about Lorem ipsum,giving information on its origin, as well as random Lipsum generator","Reference site about Lorem ipsum,giving information on its origin, as well as random Lipsum generator","Reference site about Lorem ipsum,giving information on its origin, as well as random Lipsum generator")
    private val textV3 = arrayOf("23 min","23 min","23 min","23 min","23 min","23 min")


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var belliconImageView : ImageView
        lateinit var textView1: TextView
        lateinit var textView2: TextView
        lateinit var textView3: TextView
        init {
            belliconImageView = view.findViewById(R.id.imgBlueBell)
            textView1 = view.findViewById(R.id.textNotify1)
            textView2 = view.findViewById(R.id.textNotify2)
            textView3 = view.findViewById(R.id.textNotify3)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_listnotification, parent, false)
        return ViewHolder(v)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.belliconImageView.setImageResource(images[position])
        holder.textView1.text = textV1[position]
        holder.textView2.text = textV2[position]
        holder.textView3.text = textV3[position]

    }
    override fun getItemCount(): Int {
        return images.size - 1
    }
}