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
    private lateinit var textViewtAttendance: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance)
        backImgAttendace = findViewById(R.id.imgIcLeftArrow)
        imgBellIconAttendance = findViewById(R.id.imgHeaderBellIcon)
        textViewtAttendance = findViewById(R.id.textHeaderAttendance)

        backImgAttendace.visibility = View.VISIBLE
        imgBellIconAttendance.visibility = View.VISIBLE
        textViewtAttendance.visibility = View.VISIBLE

    }
}