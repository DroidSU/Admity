package com.brixham.admity.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import com.brixham.admity.R

class DownloadsActivity : AppCompatActivity() {
    private lateinit var textViewToolbarHeader : TextView
    private lateinit var imageViewBackIcon : ImageView
    private lateinit var imageViewMenuIcon : ImageView
    private lateinit var downloadGridView: GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_downloads_acitivity)

        setupViews()
    }

    private fun setupViews() {
        textViewToolbarHeader = findViewById(R.id.toolbar_header)
        textViewToolbarHeader.visibility = VISIBLE
        textViewToolbarHeader.text = resources.getString(R.string.downloads)

        imageViewBackIcon = findViewById(R.id.imgIcLeftArrow)
        imageViewBackIcon.visibility = VISIBLE
        imageViewBackIcon.setOnClickListener {
            onBackPressed()
        }

        imageViewMenuIcon = findViewById(R.id.imgMenuIcon)
        imageViewMenuIcon.visibility = GONE
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}