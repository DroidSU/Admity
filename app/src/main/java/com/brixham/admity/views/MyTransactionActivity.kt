package com.brixham.admity.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.adapters.EnquiryFormAdapter
import com.brixham.admity.adapters.MyTransactionAdapter

class MyTransactionActivity : AppCompatActivity() {

    private lateinit var textViewToolbarHeader : TextView
    private lateinit var imageViewBackIcon : ImageView
    private lateinit var imageViewMenuIcon : ImageView
    private lateinit var imgEnquiryBellIcon: ImageView

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<MyTransactionAdapter.ViewHolder>? = null
    private lateinit var recycler_adaptar : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_transaction)
        setupView()
    }

    private fun setupView() {
        imageViewBackIcon = findViewById(R.id.imgIcLeftArrow)
        imgEnquiryBellIcon = findViewById(R.id.imgHeaderBellIcon)
        textViewToolbarHeader = findViewById(R.id.toolbar_header)


        textViewToolbarHeader.text = getString(R.string.my_transaction)
        imageViewBackIcon.visibility = View.VISIBLE
        textViewToolbarHeader.visibility = View.VISIBLE

        imageViewBackIcon.setOnClickListener {
            onBackPressed()
        }
        recycler_adaptar = findViewById(R.id.transactionId_recyclerView)
        layoutManager = LinearLayoutManager(this)
        recycler_adaptar.layoutManager = layoutManager
        adapter = MyTransactionAdapter(this)
        recycler_adaptar.adapter = adapter
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}