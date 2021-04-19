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

class GeographyPaperActivity : AppCompatActivity() {

    private lateinit var backImgGeo: ImageView
    private lateinit var imgGeoViewBellIcon: ImageView
    private lateinit var textViewHeader: TextView

    private lateinit var recyclerView: RecyclerView
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<MathPaperAdapter.ViewHolder>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_geography_paper)
        setUpView()
    }

    private fun setUpView() {
        backImgGeo = findViewById(R.id.imgIcLeftArrow)
        textViewHeader = findViewById(R.id.toolbar_header)
        textViewHeader.text = getString(R.string.geography_qa_paper)

        backImgGeo.visibility = View.VISIBLE
        textViewHeader.visibility = View.VISIBLE

        backImgGeo.setOnClickListener {
            val intent = Intent(this@GeographyPaperActivity, QuestionPaperActivity::class.java)
            startActivity(intent)
            finish()
        }
        recyclerView = findViewById(R.id.geography_paper_recyclerView)

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        adapter = MathPaperAdapter()
        recyclerView.adapter = adapter

    }
}