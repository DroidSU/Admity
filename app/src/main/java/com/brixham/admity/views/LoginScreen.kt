package com.brixham.admity.views

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
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
    lateinit var linearLayout: LinearLayout
    lateinit var alertImg: ImageView
    lateinit var alertTxt: TextView
    lateinit var alertbttn: Button





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

        btn_login.setOnClickListener {
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
            if(userId.isEmpty())
                Log.d(TAG, "startLogin: User ID is null")
            else if(password.isEmpty())
                Log.d(TAG, "startLogin: Password is null")
        }
    }

    override fun callStarted() {
        Log.d(TAG, "callStarted: ")
    }

    override fun callFailed(errorMessage: String) {

        showDialog(title = String())

        Log.d(TAG, "callFailed: $errorMessage")
    }



    override fun callSuccess(data: Any) {
        val loginResponse = data as LoginResponseModel
        Log.d(TAG, "callSuccess: "+loginResponse.message)

        val intent: Intent = Intent(this, DashBoard::class.java)
        // clear activity in back stack
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    private fun showDialog(title: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.alart_password_invalid)
        linearLayout = dialog.findViewById(R.id.linearlayoutdialog)

        alertImg = findViewById(R.id.dialoglockimg)
        alertTxt = findViewById(R.id.textInvalidPass)
        alertbttn = findViewById(R.id.alartbttnOk)



        alertbttn.setOnClickListener {
            dialog.dismiss()
        }
        alertbttn.setOnClickListener { dialog.dismiss() }
        dialog.show()

    }
}