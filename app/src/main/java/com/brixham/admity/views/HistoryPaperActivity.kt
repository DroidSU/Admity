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

class HistoryPaperActivity : AppCompatActivity() {

    private lateinit var backImgHist: ImageView
    private lateinit var imgHistViewBellIcon: ImageView
    private lateinit var textViewHeader: TextView

    private lateinit var recyclerView: RecyclerView
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<MathPaperAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_paper)
        setUpView()
    }

    private fun setUpView() {
        backImgHist = findViewById(R.id.imgIcLeftArrow)
        textViewHeader = findViewById(R.id.toolbar_header)
        textViewHeader.text = getString(R.string.history_qa_paper)
        backImgHist.visibility = View.VISIBLE
        textViewHeader.visibility = View.VISIBLE
        backImgHist.setOnClickListener {
            val intent = Intent(this@HistoryPaperActivity, QuestionPaperActivity::class.java)
            startActivity(intent)
            finish()
        }
        recyclerView = findViewById(R.id.history_paper_recyclerView)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        adapter = MathPaperAdapter()
        recyclerView.adapter = adapter
    }
}