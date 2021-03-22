package com.brixham.admity.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.brixham.admity.R

class HelpActivity : AppCompatActivity() {

    private lateinit var backImgHelp: ImageView
    private lateinit var imgHelpBellIcon: ImageView
    private lateinit var textViewHeader: TextView
    private lateinit var linearLayoutHomePage: LinearLayout
    private lateinit var linearLayoutMessagePage: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)
        backImgHelp = findViewById(R.id.imgIcLeftArrow)
        imgHelpBellIcon = findViewById(R.id.imgHeaderBellIcon)
        textViewHeader = findViewById(R.id.toolbar_header)
        linearLayoutHomePage = findViewById(R.id.linearLayout_homePage)
        linearLayoutMessagePage = findViewById(R.id.linearLayout_messagePage)

        backImgHelp.visibility = View.VISIBLE
        imgHelpBellIcon.visibility = View.VISIBLE
        textViewHeader.visibility = View.VISIBLE
        textViewHeader.text = "Help"

        linearLayoutHomePage.setOnClickListener {
            val intent: Intent = Intent(this, DashBoard::class.java)
            startActivity(intent)
            finish()
        }
    }
}