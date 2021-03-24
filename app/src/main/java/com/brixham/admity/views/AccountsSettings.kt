package com.brixham.admity.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.brixham.admity.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class AccountsSettings : AppCompatActivity() {

    private lateinit var backImgAccountSettings: ImageView
    private lateinit var textViewHeader: TextView
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accounts_settings)
        backImgAccountSettings = findViewById(R.id.imgIcLeftArrow)
        textViewHeader = findViewById(R.id.toolbar_header)
        bottomNavigationView = findViewById(R.id.accountSettings_bottom_navigation)

        backImgAccountSettings.visibility = View.VISIBLE
        textViewHeader.visibility = View.VISIBLE
        textViewHeader.text = getString(R.string.account_settings)

        backImgAccountSettings.setOnClickListener {
            val intent: Intent = Intent(this, DashBoard::class.java)
            startActivity(intent)
            finish()
        }
        bottomNavigationView.setOnNavigationItemSelectedListener {
            val intent = Intent(this, DashBoard::class.java)
            intent.putExtra("itemId", it.itemId)
            startActivity(intent)
            finish()

            return@setOnNavigationItemSelectedListener true
        }

    }
}