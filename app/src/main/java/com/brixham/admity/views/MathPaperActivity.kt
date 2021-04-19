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
import com.brixham.admity.adapters.MyWarningAdapter

class MathPaperActivity : AppCompatActivity() {

    private lateinit var backImgMath: ImageView
    private lateinit var imgMathViewBellIcon: ImageView
    private lateinit var textViewHeader: TextView

    private lateinit var recyclerView: RecyclerView
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<MathPaperAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math_paper)
        setupView()
    }

    private fun setupView() {
        backImgMath = findViewById(R.id.imgIcLeftArrow)
        imgMathViewBellIcon = findViewById(R.id.imgHeaderBellIcon)
        textViewHeader = findViewById(R.id.toolbar_header)
        textViewHeader.text = getString(R.string.math_qa_paper)
        backImgMath.visibility = View.VISIBLE
        textViewHeader.visibility = View.VISIBLE

        backImgMath.setOnClickListener {
            val intent = Intent(this@MathPaperActivity, QuestionPaperActivity::class.java)
            startActivity(intent)
            finish()
        }
        recyclerView = findViewById(R.id.math_paper_recyclerView)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        adapter = MathPaperAdapter()
        recyclerView.adapter = adapter
    }
}