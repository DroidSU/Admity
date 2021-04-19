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

class PhysicsPaperActivity : AppCompatActivity() {

    private lateinit var backImgPhy: ImageView
    private lateinit var imgPhyViewBellIcon: ImageView
    private lateinit var textViewHeader: TextView

    private lateinit var recyclerView: RecyclerView
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<MathPaperAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physics_paper)
        setupView()
    }

    private fun setupView() {
        backImgPhy = findViewById(R.id.imgIcLeftArrow)
        imgPhyViewBellIcon = findViewById(R.id.imgHeaderBellIcon)
        textViewHeader = findViewById(R.id.toolbar_header)
        textViewHeader.text = getString(R.string.physics_qa_paper)
        backImgPhy.visibility = View.VISIBLE
        textViewHeader.visibility = View.VISIBLE

        backImgPhy.setOnClickListener {
            val intent = Intent(this@PhysicsPaperActivity, QuestionPaperActivity::class.java)
            startActivity(intent)
            finish()
        }
        recyclerView = findViewById(R.id.physics_paper_recyclerView)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        adapter = MathPaperAdapter()
        recyclerView.adapter = adapter

    }
}