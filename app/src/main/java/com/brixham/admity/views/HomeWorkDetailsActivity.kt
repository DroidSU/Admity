package com.brixham.admity.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.brixham.admity.R
import com.brixham.admity.adapters.HomeWorkAdapter
import com.brixham.admity.fragments.HomeWorkFragment

class HomeWorkDetailsActivity : AppCompatActivity() {

    private lateinit var textViewToolbarHeader : TextView
    private lateinit var imageViewBackIcon : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_work_details)
        setupView()
    }

    private fun setupView() {
        imageViewBackIcon = findViewById(R.id.imgIcLeftArrow)
        textViewToolbarHeader = findViewById(R.id.toolbar_header)

        textViewToolbarHeader.text = getString(R.string.home_work_details)
        imageViewBackIcon.visibility = View.VISIBLE
        textViewToolbarHeader.visibility = View.VISIBLE

        imageViewBackIcon.setOnClickListener {
            val intent: Intent = Intent(this, DashBoard::class.java)
            this.startActivity(intent)
            finish()
        }
    }

}