package com.brixham.admity.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.brixham.admity.R

class EventDetails : AppCompatActivity() {

    private lateinit var backImgMsg: ImageView
    private lateinit var imgEventDetailsBellIcon: ImageView
    private lateinit var textViewEventDetails: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_details)
        backImgMsg = findViewById(R.id.imgIcLeftArrow)
        imgEventDetailsBellIcon = findViewById(R.id.imgHeaderBellIcon)
        textViewEventDetails = findViewById(R.id.textHeaderEventDetails)

        backImgMsg.visibility = View.VISIBLE
        textViewEventDetails.visibility = View.VISIBLE
        imgEventDetailsBellIcon.visibility = View.VISIBLE

        imgEventDetailsBellIcon.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, HolidayView::class.java))
        })

    }
}