package com.brixham.admity.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.skyhope.showmoretextview.ShowMoreTextView

class NewsAdapter: RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private val textV1 = arrayOf("News Title 1","News Title 2","News Title 3","News Title 4","News Title 5")
    private val images2 = intArrayOf(
        R.drawable.ic_bookmark,
        R.drawable.ic_bookmark,
        R.drawable.ic_bookmark,
        R.drawable.ic_bookmark,
        R.drawable.ic_bookmark,)
    private val textV2 = arrayOf("23 Mar 2021","23 Mar 2021","23 Mar 2021","23 Mar 2021","23 Mar 2021")
    private val textV3 = arrayOf("Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, grapic or web designs and  or lipsum as it is sometimes known,","Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, grapic or web designs and  or lipsum as it is sometimes known,","Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, grapic or web designs and  or lipsum as it is sometimes known,","Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, grapic or web designs and  or lipsum as it is sometimes known,","Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, grapic or web designs and  or lipsum as it is sometimes known,")
    private val textV4 = arrayOf("5 min","10 min","12 min","15 min","10 min")

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var textViewTitle: TextView = view.findViewById(R.id.news_title)
        var displayBookmarkImageView : ImageView = view.findViewById(R.id.news_bookmark_img)
        var textViewDate: TextView = view.findViewById(R.id.news_date)
        var textViewNewsDetails: ShowMoreTextView = view.findViewById(R.id.textView_showmore)
        var textViewNewsTime: TextView = view.findViewById(R.id.news_time)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.news_layout_list, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        holder.textViewTitle.text = textV1[position]
        holder.displayBookmarkImageView.setImageResource(images2[position])
        holder.textViewDate.text = textV2[position]
        holder.textViewNewsDetails.text = textV3[position]
        holder.textViewNewsTime.text = textV4[position]
        holder.textViewNewsDetails.setShowingLine(4)
        holder.textViewNewsDetails.addShowMoreText("View More")
        holder.textViewNewsDetails.addShowLessText("View Less")
        holder.textViewNewsDetails.setShowMoreColor(Color.RED)
    }
    override fun getItemCount(): Int {
        return textV1.size
    }
}