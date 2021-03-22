package com.brixham.admity.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.brixham.admity.R
import com.brixham.admity.network.NetworkCallback
import com.brixham.admity.utilities.UtilityMethods

class ForgotPassword : AppCompatActivity(), NetworkCallback {

    private lateinit var imageBackForgotPassword: ImageView
    private lateinit var textViewHeader: TextView
    private lateinit var buttonForgotPassword: Button
    private lateinit var progressDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        imageBackForgotPassword = findViewById(R.id.imgIcLeftArrow)
        textViewHeader = findViewById(R.id.toolbar_header)
        buttonForgotPassword = findViewById(R.id.button_forgot_pwd)
        imageBackForgotPassword.visibility = View.VISIBLE
        textViewHeader.visibility = View.VISIBLE
        textViewHeader.text = "Forgot Password"

        imageBackForgotPassword.setOnClickListener {
            val intent: Intent = Intent(this, LoginScreen::class.java)
            startActivity(intent)
            finish()
        }
        progressDialog = UtilityMethods().showProgressDialog(this)
        buttonForgotPassword.setOnClickListener {
        }
    }

    override fun callStarted() {
        TODO("Not yet implemented")
    }

    override fun callFailed(errorMessage: String) {
        TODO("Not yet implemented")
    }

    override fun callSuccess(data: Any) {
        TODO("Not yet implemented")
    }
}