package com.brixham.admity.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.adapters.TransportAdapter

class TransportActivity : AppCompatActivity() {

    private lateinit var backImgMsg: ImageView
    private lateinit var imgTransportBellIcon: ImageView
    private lateinit var textViewHeader: TextView

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<TransportAdapter.ViewHolder>? = null
    private lateinit var recycler_adaptar : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transport)
        backImgMsg = findViewById(R.id.imgIcLeftArrow)
        imgTransportBellIcon = findViewById(R.id.imgHeaderBellIcon)
        textViewHeader = findViewById(R.id.toolbar_header)
        recycler_adaptar = findViewById(R.id.recycler_holiday)
        backImgMsg.visibility = View.VISIBLE
        imgTransportBellIcon.visibility = View.VISIBLE
        textViewHeader.visibility = View.VISIBLE
        textViewHeader.text = getString(R.string.transport)

        layoutManager = LinearLayoutManager(this)
        recycler_adaptar.layoutManager = layoutManager


        adapter = TransportAdapter()
        recycler_adaptar.adapter = adapter


    }
}