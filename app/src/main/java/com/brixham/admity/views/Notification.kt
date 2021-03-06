package com.brixham.admity.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.adaptars.RecyclerAdapter

class Notification : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    private lateinit var recycler_adaptar : RecyclerView
    private lateinit var imageBack: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        imageBack = findViewById(R.id.imgBacknotification)

        imageBack.setOnClickListener(View.OnClickListener {
            var intent: Intent = Intent(this, DashBoard::class.java)
            Intent.FLAG_ACTIVITY_CLEAR_TASK
            Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        })

        recycler_adaptar = findViewById(R.id.recyclerNotification)

        layoutManager = LinearLayoutManager(this)
        recycler_adaptar.layoutManager = layoutManager


        adapter = RecyclerAdapter()
        recycler_adaptar.adapter = adapter


    }
}