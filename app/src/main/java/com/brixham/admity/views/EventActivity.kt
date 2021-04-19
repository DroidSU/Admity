package com.brixham.admity.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.adapters.EventAdapter
import com.brixham.admity.adapters.TransportAdapter

class EventActivity : AppCompatActivity() {

    private lateinit var backImgEvent: ImageView
    private lateinit var imgEventViewBellIcon: ImageView
    private lateinit var textViewHeader: TextView

    private lateinit var recyclerView: RecyclerView
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<EventAdapter.ViewHolder>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)
        setupView()
    }

    private fun setupView() {
        backImgEvent = findViewById(R.id.imgIcLeftArrow)
        imgEventViewBellIcon = findViewById(R.id.imgHeaderBellIcon)
        textViewHeader = findViewById(R.id.toolbar_header)
        recyclerView = findViewById(R.id.event_recyclerView)
        textViewHeader.text = getString(R.string.event)
        backImgEvent.visibility = View.VISIBLE
        textViewHeader.visibility = View.VISIBLE

        backImgEvent.setOnClickListener {
            onBackPressed()
        }
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        adapter = EventAdapter()
        recyclerView.adapter = adapter
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}