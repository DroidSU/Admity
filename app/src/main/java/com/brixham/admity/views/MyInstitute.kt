package com.brixham.admity.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.brixham.admity.R

class MyInstitute : AppCompatActivity() {


    private lateinit var backImgInstitute: ImageView
    private lateinit var imgInstituteViewBellIcon: ImageView
    private lateinit var textViewHeader: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_institute)
        backImgInstitute = findViewById(R.id.imgIcLeftArrow)
        imgInstituteViewBellIcon = findViewById(R.id.imgHeaderBellIcon)
        textViewHeader = findViewById(R.id.toolbar_header)
        textViewHeader.text = getString(R.string.my_institute)
        backImgInstitute.visibility = View.VISIBLE
        textViewHeader.visibility = View.VISIBLE
        imgInstituteViewBellIcon.visibility = View.VISIBLE

        backImgInstitute.setOnClickListener {
            var intent: Intent = Intent(this, DashBoard::class.java)
            startActivity(intent)
            finish()
        }
        imgInstituteViewBellIcon.setOnClickListener {
            var intent: Intent = Intent(this, NotificationActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}