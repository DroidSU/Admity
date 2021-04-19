package com.brixham.admity.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.adapters.MathPaperAdapter
import com.brixham.admity.adapters.NewsAdapter

class NewsActivity : AppCompatActivity() {

    private lateinit var backImgNews: ImageView
    private lateinit var imgNewsViewBellIcon: ImageView
    private lateinit var textViewHeader: TextView

    private lateinit var recyclerView: RecyclerView
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<NewsAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        setUpViews()
    }

    private fun setUpViews() {
        backImgNews = findViewById(R.id.imgIcLeftArrow)
        imgNewsViewBellIcon = findViewById(R.id.imgHeaderBellIcon)
        textViewHeader = findViewById(R.id.toolbar_header)
        textViewHeader.text = getString(R.string.news)
        backImgNews.visibility = View.VISIBLE
        textViewHeader.visibility = View.VISIBLE

        backImgNews.setOnClickListener {
            onBackPressed()
        }
        recyclerView = findViewById(R.id.news_recyclerView)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        adapter = NewsAdapter()
        recyclerView.adapter = adapter

    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}