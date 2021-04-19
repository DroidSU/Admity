package com.brixham.admity.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.adapters.EmergencyNoticeAdapter
import com.brixham.admity.adapters.ImportantLinkAdapter

class EmergencyNoticeActivity : AppCompatActivity() {

    private lateinit var backImgEmerNotice: ImageView
    private lateinit var imgEmerNoticeViewBellIcon: ImageView
    private lateinit var textViewHeader: TextView

    private lateinit var recyclerView: RecyclerView
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<EmergencyNoticeAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergency_notice)
        setUpViews()
    }

    private fun setUpViews() {
        backImgEmerNotice = findViewById(R.id.imgIcLeftArrow)
        imgEmerNoticeViewBellIcon = findViewById(R.id.imgHeaderBellIcon)
        textViewHeader = findViewById(R.id.toolbar_header)

        textViewHeader.text = getString(R.string.emergency_notice)
        backImgEmerNotice.visibility = View.VISIBLE
        textViewHeader.visibility = View.VISIBLE

        backImgEmerNotice.setOnClickListener {
            onBackPressed()
        }
        recyclerView = findViewById(R.id.emergency_notice_recyclerView)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        adapter = EmergencyNoticeAdapter()
        recyclerView.adapter = adapter
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}