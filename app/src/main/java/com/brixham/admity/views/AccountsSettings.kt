package com.brixham.admity.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.brixham.admity.R

class AccountsSettings : AppCompatActivity() {

    private lateinit var backImgAccountSettings: ImageView
    private lateinit var textViewHeader: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accounts_settings)
        backImgAccountSettings = findViewById(R.id.imgIcLeftArrow)
        textViewHeader = findViewById(R.id.toolbar_header)

        backImgAccountSettings.visibility = View.VISIBLE
        textViewHeader.visibility = View.VISIBLE
        textViewHeader.text = "Account Settings"

        backImgAccountSettings.setOnClickListener {
            val intent: Intent = Intent(this, DashBoard::class.java)
            startActivity(intent)
            finish()
        }

    }
}