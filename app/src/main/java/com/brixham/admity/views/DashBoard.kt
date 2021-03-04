package com.brixham.admity.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.brixham.admity.R

class DashBoard : AppCompatActivity() {
    private lateinit var imgBellIcon: ImageView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        imgBellIcon = findViewById(R.id.imgBell)
        imgBellIcon.setOnClickListener(View.OnClickListener {
            var intent: Intent = Intent(this, Notification::class.java)
            startActivity(intent)
        })


    }
}