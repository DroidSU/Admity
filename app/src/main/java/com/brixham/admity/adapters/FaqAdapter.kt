package com.brixham.admity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.models.FAQResponseData
import com.brixham.admity.models.NoticeResponseData
import java.text.SimpleDateFormat
import java.util.*

class FaqAdapter(private var faqList: ArrayList<FAQResponseData>) :
    RecyclerView.Adapter<FaqAdapter.FaqViewHolder>() {

    private lateinit var view : View

    var Date: String? = null
    class FaqViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var faqPanel : TextView = itemView.findViewById(R.id.faq_panel)
        var faqTopicName : TextView = itemView.findViewById(R.id.faq_topicName)
        var faqQues : TextView = itemView.findViewById(R.id.faq_ques)
        var faqAns : TextView = itemView.findViewById(R.id.faq_ans)
        //var noticeDetils: TextView = itemView.findViewById(R.id.notice_description)


        //var textViewTime: TextView = itemView.findViewById(R.id.textViewNotifyTime)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FaqAdapter.FaqViewHolder {
        view = LayoutInflater.from(parent.context).inflate(R.layout.faq_layout_list, parent, false)
        return FaqAdapter.FaqViewHolder(view)

        /*calendar = Calendar.getInstance()
        dateFormat = SimpleDateFormat("dd-MM-yyyy")
        Date = dateFormat.format(calendar.time)*/
        //noticeStartDate.text = Date

    }

    override fun onBindViewHolder(holder: FaqAdapter.FaqViewHolder, position: Int) {
        holder.faqPanel.text = faqList[position].panel as CharSequence?
        holder.faqTopicName.text = faqList[position].topic_Name as CharSequence?
        holder.faqQues.text = faqList[position].question
        holder.faqAns.text = faqList[position].answer


    }

    override fun getItemCount(): Int {
        return faqList.size
    }




}