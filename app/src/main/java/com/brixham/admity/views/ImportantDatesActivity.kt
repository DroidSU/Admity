package com.brixham.admity.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.adapters.ImportantDatesAdapter
import com.brixham.admity.adapters.ImportantLinkAdapter

class ImportantDatesActivity : AppCompatActivity() {

    private lateinit var backImgImpDates : ImageView
    private lateinit var imgBellIcon : ImageView
    private lateinit var textViewHeader : TextView

    private lateinit var recyclerView: RecyclerView
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<ImportantDatesAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_important_dates)
        setUpViews()
    }

    private fun setUpViews() {
        backImgImpDates = findViewById(R.id.imgIcLeftArrow)
        textViewHeader = findViewById(R.id.toolbar_header)

        textViewHeader.text = getString(R.string.important_dates)
        backImgImpDates.visibility = View.VISIBLE
        textViewHeader.visibility = View.VISIBLE

        backImgImpDates.setOnClickListener {
            onBackPressed()
        }
        recyclerView = findViewById(R.id.important_dates_recyclerView)

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        adapter = ImportantDatesAdapter()
        recyclerView.adapter = adapter
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}