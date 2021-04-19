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

class BiologyPaperActivity : AppCompatActivity() {

    private lateinit var backImgBio: ImageView
    private lateinit var imgBioViewBellIcon: ImageView
    private lateinit var textViewHeader: TextView

    private lateinit var recyclerView: RecyclerView
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<MathPaperAdapter.ViewHolder>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biology_paper)
        setUpView()
    }

    private fun setUpView() {
            backImgBio = findViewById(R.id.imgIcLeftArrow)
            textViewHeader = findViewById(R.id.toolbar_header)
            textViewHeader.text = getString(R.string.biology_qa_paper)
            backImgBio.visibility = View.VISIBLE
            textViewHeader.visibility = View.VISIBLE
            backImgBio.setOnClickListener {
                val intent = Intent(this@BiologyPaperActivity, QuestionPaperActivity::class.java)
                startActivity(intent)
                finish()
            }
            recyclerView = findViewById(R.id.biology_paper_recyclerView)
            layoutManager = LinearLayoutManager(this)
            recyclerView.layoutManager = layoutManager

            adapter = MathPaperAdapter()
            recyclerView.adapter = adapter


    }
}