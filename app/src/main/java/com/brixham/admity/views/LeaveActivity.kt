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
import com.brixham.admity.adapters.LeaveAdapter

class LeaveActivity : AppCompatActivity() {

    private lateinit var backImgLeave: ImageView
    private lateinit var imgLeaveViewBellIcon: ImageView
    private lateinit var textViewHeader: TextView

    private lateinit var recyclerView: RecyclerView
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<LeaveAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leave)
        setupView()
    }

    private fun setupView() {
        backImgLeave = findViewById(R.id.imgIcLeftArrow)
        imgLeaveViewBellIcon = findViewById(R.id.imgHeaderBellIcon)
        textViewHeader = findViewById(R.id.toolbar_header)

        textViewHeader.text = getString(R.string.leave_application)
        backImgLeave.visibility = View.VISIBLE
        textViewHeader.visibility = View.VISIBLE

        backImgLeave.setOnClickListener {
            onBackPressed()
        }
        recyclerView = findViewById(R.id.leave_recyclerView)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        adapter = LeaveAdapter()
        recyclerView.adapter = adapter
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}