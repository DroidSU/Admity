package com.brixham.admity.adaptars

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R


class ChatRecyclerAdapter: RecyclerView.Adapter<ChatRecyclerAdapter.ViewHolder>() {


    private val textOutgoingV1 = arrayOf("kfklvmvlkmvklfvmfkvmmmkm m mfbhfbfvbfvbfvfdvdvnjjnjnjn vjnj jn jncj n n n jfjjvvvvvnnnn  nnjn jvn vn vn v ","kfklvmvlkmvklfvmfkvmmmkm m mfbhfbfvbfvbfvfdvdvnjjnjnjn vjnj jn jncj n n n jfjjvvvvvnnnn  nnjn jvn vn vn v ","kfklvmvlkmvklfvmfkvmmmkm m mfbhfbfvbfvbfvfdvdvnjjnjnjn vjnj jn jncj n n n jfjjvvvvvnnnn  nnjn jvn vn vn v ","kfklvmvlkmvklfvmfkvmmmkm m mfbhfbfvbfvbfvfdvdvnjjnjnjn vjnj jn jncj n n n jfjjvvvvvnnnn  nnjn jvn vn vn v ","kfklvmvlkmvklfvmfkvmmmkm m mfbhfbfvbfvbfvfdvdvnjjnjnjn vjnj jn jncj n n n jfjjvvvvvnnnn  nnjn jvn vn vn v ","kfklvmvlkmvklfvmfkvmmmkm m mfbhfbfvbfvbfvfdvdvnjjnjnjn vjnj jn jncj n n n jfjjvvvvvnnnn  nnjn jvn vn vn v ")
    private val imagesOutgoing = intArrayOf(R.drawable.imgdp,R.drawable.imgdp,R.drawable.imgdp,R.drawable.imgdp,R.drawable.imgdp,R.drawable.imgdp,R.drawable.imgdp)
    private val imagesIncoming = intArrayOf(R.drawable.imgdp,R.drawable.imgdp,R.drawable.imgdp,R.drawable.imgdp,R.drawable.imgdp,R.drawable.imgdp,R.drawable.imgdp)
    private val textIncomingV1 = arrayOf("kfklvmvlkmvklfvmfkvmmmkm m mfbhfbfvbfvbfvfdvdvnjjnjnjn vjnj jn jncj n n n jfjjvvvvvnnnn  nnjn jvn vn vn v ","kfklvmvlkmvklfvmfkvmmmkm m mfbhfbfvbfvbfvfdvdvnjjnjnjn vjnj jn jncj n n n jfjjvvvvvnnnn  nnjn jvn vn vn v ","kfklvmvlkmvklfvmfkvmmmkm m mfbhfbfvbfvbfvfdvdvnjjnjnjn vjnj jn jncj n n n jfjjvvvvvnnnn  nnjn jvn vn vn v ","kfklvmvlkmvklfvmfkvmmmkm m mfbhfbfvbfvbfvfdvdvnjjnjnjn vjnj jn jncj n n n jfjjvvvvvnnnn  nnjn jvn vn vn v ","kfklvmvlkmvklfvmfkvmmmkm m mfbhfbfvbfvbfvfdvdvnjjnjnjn vjnj jn jncj n n n jfjjvvvvvnnnn  nnjn jvn vn vn v ","kfklvmvlkmvklfvmfkvmmmkm m mfbhfbfvbfvbfvfdvdvnjjnjnjn vjnj jn jncj n n n jfjjvvvvvnnnn  nnjn jvn vn vn v ")




    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var chatOutgoigText : TextView = view.findViewById(R.id.textOutgoing)
        var circleImgOutgoing: ImageView = view.findViewById(R.id.circleImgOutgoing)
        var circleImgIncoming: ImageView = view.findViewById(R.id.circleImgIncoming)
        var chatIncomingText: TextView = view.findViewById(R.id.textIncoming)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_chatlist, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.chatOutgoigText.text = textOutgoingV1[position]
        holder.circleImgOutgoing.setImageResource(imagesOutgoing[position])
        holder.circleImgIncoming.setImageResource(imagesIncoming[position])
        holder.chatIncomingText.text = textIncomingV1[position]
    }

    override fun getItemCount(): Int {
        return textOutgoingV1.size - 1
    }




}