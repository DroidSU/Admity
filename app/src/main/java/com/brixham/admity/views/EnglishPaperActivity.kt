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

class EnglishPaperActivity : AppCompatActivity() {

    private lateinit var backImgEng: ImageView
    private lateinit var imgEngViewBellIcon: ImageView
    private lateinit var textViewHeader: TextView

    private lateinit var recyclerView: RecyclerView
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<MathPaperAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_english_paper)
        setupView()
    }

    private fun setupView() {
        backImgEng = findViewById(R.id.imgIcLeftArrow)
        imgEngViewBellIcon = findViewById(R.id.imgHeaderBellIcon)
        textViewHeader = findViewById(R.id.toolbar_header)
        textViewHeader.text = getString(R.string.english_qa_paper)
        backImgEng.visibility = View.VISIBLE
        textViewHeader.visibility = View.VISIBLE

        backImgEng.setOnClickListener {
            val intent = Intent(this@EnglishPaperActivity, QuestionPaperActivity::class.java)
            startActivity(intent)
            finish()
        }
        recyclerView = findViewById(R.id.english_paper_recyclerView)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        adapter = MathPaperAdapter()
        recyclerView.adapter = adapter
    }
}