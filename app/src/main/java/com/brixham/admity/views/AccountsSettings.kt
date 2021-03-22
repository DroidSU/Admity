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
    private lateinit var textViewAccountSettings: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accounts_settings)
        backImgAccountSettings = findViewById(R.id.imgIcLeftArrow)
        textViewAccountSettings = findViewById(R.id.textHeaderAccountSettings)

        backImgAccountSettings.visibility = View.VISIBLE
        textViewAccountSettings.visibility = View.VISIBLE

        backImgAccountSettings.setOnClickListener {
            var intent: Intent = Intent(this, DashBoard::class.java)
            startActivity(intent)
            finish()
        }

    }
}