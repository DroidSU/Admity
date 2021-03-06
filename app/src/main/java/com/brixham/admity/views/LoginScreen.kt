package com.brixham.admity.views

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.brixham.admity.R
import com.brixham.admity.models.LoginResponseModel
import com.brixham.admity.network.NetworkCallback
import com.brixham.admity.utilities.UtilityMethods
import com.brixham.admity.viewmodels.LoginViewModel
import com.brixham.admity.viewmodels.LoginViewModelFactory
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance


class LoginScreen : AppCompatActivity(), KodeinAware, NetworkCallback {
    override val kodein by closestKodein()

    private val loginViewModelFactory: LoginViewModelFactory by instance()
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var btn_login : Button
    private lateinit var editTextUserId : TextInputEditText
    private lateinit var editTextPassword : TextInputEditText
    private lateinit var progressDialog: AlertDialog
    private lateinit var textUnderline: TextView

    private var userId = ""
    private var password = ""

    var TAG = LoginScreen::class.java.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        loginViewModel = ViewModelProvider(this, loginViewModelFactory).get(LoginViewModel::class.java)

        //showProgress()

        btn_login = findViewById(R.id.btn_login)
        editTextUserId = findViewById(R.id.editText_sId)
        editTextPassword = findViewById(R.id.editText_password)
        textUnderline = findViewById(R.id.textUnderline)

        btn_login.setOnClickListener {
            startLogin()


        }

        progressDialog = UtilityMethods().showProgressDialog(this)
    }

    private fun startLogin(){
        userId = editTextUserId.text.toString()
        password = editTextPassword.text.toString()

        if(userId.isNotBlank() && userId.isNotEmpty() && password.isNotBlank() && password.isNotEmpty()){
            CoroutineScope(Dispatchers.IO).launch {
                loginViewModel.loginUser(userId, password, "", this@LoginScreen)
            }
        }
        else{
            if(userId.isEmpty())
                Log.d(TAG, "startLogin: User ID is null")
            else if(password.isEmpty())
                Log.d(TAG, "startLogin: Password is null")
        }
    }

    override fun callStarted() {
        CoroutineScope(Dispatchers.Main).launch {
            if (!progressDialog.isShowing)
                progressDialog.show()
        }
    }

    override fun callFailed(errorMessage: String) {
        CoroutineScope(Dispatchers.Main).launch {
            if(progressDialog.isShowing)
                progressDialog.cancel()

            Log.d(TAG, "callFailed: $errorMessage")
            val failedDialog = UtilityMethods().showFailedDialog(this@LoginScreen, errorMessage)
            val btnClose = failedDialog.findViewById<Button>(R.id.btn_close)
            btnClose!!.setOnClickListener {
                failedDialog.dismiss()
            }

            failedDialog.show()
        }
    }



    override fun callSuccess(data: Any) {
        CoroutineScope(Dispatchers.Main).launch {
            if(progressDialog.isShowing)
                progressDialog.cancel()

            val loginResponse = data as LoginResponseModel
            Log.d(TAG, "callSuccess: "+loginResponse.message)
            if (loginResponse.status) {
                val intent = Intent(this@LoginScreen, DashBoard::class.java)
                startActivity(intent)
                finish()
            }
            else{

            }
        }
    }
}