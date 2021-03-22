package com.brixham.admity.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.brixham.admity.R

class HolidayView : AppCompatActivity() {

    private lateinit var backImgMsg: ImageView
    private lateinit var imgHolidayViewBellIcon: ImageView
    private lateinit var textViewHeader: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_holiday_view)

        backImgMsg = findViewById(R.id.imgIcLeftArrow)
        imgHolidayViewBellIcon = findViewById(R.id.imgHeaderBellIcon)
        textViewHeader = findViewById(R.id.toolbar_header)
        backImgMsg.visibility = View.VISIBLE
        textViewHeader.visibility = View.VISIBLE

        textViewHeader.text = "Holiday"

        imgHolidayViewBellIcon.visibility = View.VISIBLE

        imgHolidayViewBellIcon.setOnClickListener {
            startActivity(Intent(this, StudentProfile::class.java))
        }
    }
}