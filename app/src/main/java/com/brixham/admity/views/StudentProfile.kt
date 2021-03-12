package com.brixham.admity.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.brixham.admity.R

class StudentProfile : AppCompatActivity() {

    private lateinit var backImgStudentProf: ImageView
    private lateinit var imgBellIconStudentProf: ImageView
    private lateinit var textViewtudentProf: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_profile)
        backImgStudentProf = findViewById(R.id.imgIcLeftArrow)
        imgBellIconStudentProf = findViewById(R.id.imgHeaderBellIcon)
        textViewtudentProf = findViewById(R.id.textHeaderStudentProfile)

        backImgStudentProf.visibility = View.VISIBLE
        imgBellIconStudentProf.visibility = View.VISIBLE
        textViewtudentProf.visibility = View.VISIBLE
    }
}