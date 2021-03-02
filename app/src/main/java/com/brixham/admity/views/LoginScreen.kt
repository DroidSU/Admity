package com.brixham.admity.views

import android.R.attr.button
import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.text.Html
//import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.brixham.admity.R
import com.brixham.admity.models.LoginResponseModel
import com.brixham.admity.network.NetworkCallback
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
    private lateinit var alertDialog: AlertDialog
    private lateinit var inflater: LayoutInflater
    private lateinit var dialogview: View
    private lateinit var builder: AlertDialog.Builder
    private lateinit var textUnderline: TextView



    lateinit var msg: String



    private var userId = ""
    var password = ""
    var TAG = LoginScreen::class.java.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        loginViewModel = ViewModelProviders.of(this, loginViewModelFactory).get(LoginViewModel::class.java)
        //showProgress()
        btn_login = findViewById(R.id.btn_login)
        editTextUserId = findViewById(R.id.editText_sId)
        editTextPassword = findViewById(R.id.editText_password)
        textUnderline = findViewById(R.id.textUnderline)
        textUnderline.setText(Html.fromHtml(String.format(getString(R.string.your_string_here), )))
        textUnderline.setPaintFlags(textUnderline.getPaintFlags() or Paint.UNDERLINE_TEXT_FLAG)

        btn_login.setOnClickListener {
            val intent: Intent = Intent(this, DashBoard::class.java)
            startActivity(intent)
            startLogin()
        }
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

        }
    }

    override fun callStarted() {





        Log.d(TAG, "callStarted: ")
    }

    override fun callFailed(errorMessage: String) {

    }

    override fun callSuccess(data: Any) {
        val loginResponse = data as LoginResponseModel
        Log.d(TAG, "callSuccess: "+loginResponse.message)
    }

    /*fun showProgress() {
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogview = inflater.inflate(R.layout.dialog_loading, null)
        alertDialog.setView(dialogview)
        alertDialog = builder.create()
        alertDialog.show()


    }*/
}