package com.brixham.admity.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.adapters.RecyclerAdapter

class Notification : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    private lateinit var recycler_adaptar : RecyclerView
    private lateinit var imageBackNotification: ImageView
    private lateinit var textViewHeader: TextView
    private lateinit var linearLayoutHomePage1: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        imageBackNotification = findViewById(R.id.imgIcLeftArrow)
        textViewHeader = findViewById(R.id.toolbar_header)
        imageBackNotification.setOnClickListener {
            val intent = Intent(this, DashBoard::class.java)
            startActivity(intent)
            finish()
        }

        imageBackNotification.visibility = View.VISIBLE
        textViewHeader.visibility = View.VISIBLE
        textViewHeader.text = "Notification"

        recycler_adaptar = findViewById(R.id.recyclerNotification)

        layoutManager = LinearLayoutManager(this)
        recycler_adaptar.layoutManager = layoutManager


        adapter = RecyclerAdapter()
        recycler_adaptar.adapter = adapter


    }
}