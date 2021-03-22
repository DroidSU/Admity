package com.brixham.admity.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.brixham.admity.R

class Attendance : AppCompatActivity() {

    private lateinit var backImgAttendace: ImageView
    private lateinit var imgBellIconAttendance: ImageView
    private lateinit var textViewHeader: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance)
        backImgAttendace = findViewById(R.id.imgIcLeftArrow)
        imgBellIconAttendance = findViewById(R.id.imgHeaderBellIcon)

        textViewHeader = findViewById(R.id.toolbar_header)
        textViewHeader.text = "Attendance"


        backImgAttendace.visibility = View.VISIBLE
        imgBellIconAttendance.visibility = View.VISIBLE
        textViewHeader.visibility = View.VISIBLE

    }
}