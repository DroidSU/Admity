package com.brixham.admity.views

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.brixham.admity.R


class DashBoard : AppCompatActivity() {

    private lateinit var imgBellIcon: ImageView

    var serviceTitles = arrayOf(
        "Google",
        "Github",
        "Instagram",
        "Facebook",
        "Flickr",
        "Pinterest",
        "Quora",
        "Twitter",
        "Vimeo",
        "WordPress",
        "Youtube"

    )
    var serviceImages = intArrayOf(
        R.drawable.syllabus,
        R.drawable.school,
        R.drawable.teacher,
        R.drawable.attendance,
        R.drawable.fee,
        R.drawable.leave,
        R.drawable.present,
        R.drawable.present,
        R.drawable.event,
        R.drawable.holiday,
        R.drawable.notice,
        R.drawable.present
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        imgBellIcon = findViewById(R.id.imgBell)

        imgBellIcon.setOnClickListener {
            val intent: Intent = Intent(this, Notification::class.java)
//            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }


    }
}




