package com.brixham.admity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.models.NotificationsResponseData

class NotificationsRecyclerAdapter(private var notificationsList : ArrayList<NotificationsResponseData>) :
    RecyclerView.Adapter<NotificationsRecyclerAdapter.NotificationViewHolder>() {

    private lateinit var view : View

    class NotificationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var belliconImageView : ImageView = itemView.findViewById(R.id.imgBlueBell)
        var textViewTitle : TextView = itemView.findViewById(R.id.textView_notify_heading)
        var textViewDetails: TextView = itemView.findViewById(R.id.textView_notify_details)
        var textViewTime: TextView = itemView.findViewById(R.id.textViewNotifyTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : NotificationViewHolder{
        view = LayoutInflater.from(parent.context).inflate(R.layout.layout_notification_item, parent, false)
        return NotificationViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.textViewTitle.text = notificationsList[position].type
        holder.textViewDetails.text = notificationsList[position].head_Line
    }

    override fun getItemCount(): Int {
        return notificationsList.size
    }
}