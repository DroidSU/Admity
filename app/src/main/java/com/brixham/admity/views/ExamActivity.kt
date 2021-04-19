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
import com.brixham.admity.adapters.ExamAdapter

class ExamActivity : AppCompatActivity() {

    private lateinit var backImgExam: ImageView
    private lateinit var imgExamViewBellIcon: ImageView
    private lateinit var textViewHeader: TextView

    private lateinit var recyclerView: RecyclerView
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<ExamAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exam)
        setupView()
    }

    private fun setupView() {
        backImgExam = findViewById(R.id.imgIcLeftArrow)
        imgExamViewBellIcon = findViewById(R.id.imgHeaderBellIcon)
        textViewHeader = findViewById(R.id.toolbar_header)
        recyclerView = findViewById(R.id.exam_recyclerView)
        textViewHeader.text = getString(R.string.exam_schedule)
        backImgExam.visibility = View.VISIBLE
        textViewHeader.visibility = View.VISIBLE

        backImgExam.setOnClickListener {
            onBackPressed()
        }
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        adapter = ExamAdapter()
        recyclerView.adapter = adapter

    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}