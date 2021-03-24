package com.brixham.admity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.models.MyPropectusData
import com.brixham.admity.models.NoticeResponseData
import java.text.SimpleDateFormat
import java.util.*

class NoticeAdapter(private var noticeList: ArrayList<NoticeResponseData>) :
    RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder>() {

    private lateinit var view : View
    private lateinit var dateFormat: SimpleDateFormat
    private lateinit var calendar: Calendar
    private lateinit var noticeStartDate: TextView
    var Date: String? = null
    class NoticeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var noticeId : TextView = itemView.findViewById(R.id.list_NoticeId)
        var noticeName : TextView = itemView.findViewById(R.id.list_NoticeName)
        var noticeStartDate : TextView = itemView.findViewById(R.id.notice_startDate)
        var noticeEndDate : TextView = itemView.findViewById(R.id.notice_endDate)
        var noticeDetils: TextView = itemView.findViewById(R.id.notice_description)


        //var textViewTime: TextView = itemView.findViewById(R.id.textViewNotifyTime)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NoticeAdapter.NoticeViewHolder {
        view = LayoutInflater.from(parent.context).inflate(R.layout.notice_layout_list, parent, false)
        return NoticeAdapter.NoticeViewHolder(view)

        /*calendar = Calendar.getInstance()
        dateFormat = SimpleDateFormat("dd-MM-yyyy")
        Date = dateFormat.format(calendar.time)*/
        //noticeStartDate.text = Date

    }

    override fun onBindViewHolder(holder: NoticeAdapter.NoticeViewHolder, position: Int) {
        holder.noticeId.text = noticeList[position].pk_NoticeId.toString()
        holder.noticeName.text = noticeList[position].noticename
        holder.noticeStartDate.text = noticeList[position].startdate
        holder.noticeEndDate.text = noticeList[position].enddate as CharSequence?
        holder.noticeDetils.text = noticeList[position].notice

    }

    override fun getItemCount(): Int {
        return noticeList.size
    }




}