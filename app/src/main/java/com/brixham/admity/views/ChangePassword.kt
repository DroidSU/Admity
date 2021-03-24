package com.brixham.admity.views

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.brixham.admity.R
import com.brixham.admity.models.ChangePasswordResponseModel
import com.brixham.admity.network.NetworkCallback
import com.brixham.admity.utilities.Constants
import com.brixham.admity.utilities.UtilityMethods
import com.brixham.admity.viewmodels.ChangePasswordViewModel
import com.brixham.admity.viewmodels.ChangePasswordViewModelFactory
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class ChangePassword : AppCompatActivity(), KodeinAware, NetworkCallback {
    override val kodein by closestKodein()

    private val changepwdViewModelFactory: ChangePasswordViewModelFactory by instance()
    private lateinit var changepwdViewModel: ChangePasswordViewModel
    private lateinit var backImgChangePwd: ImageView
    private lateinit var imgBellIconChangePwd: ImageView
    private lateinit var textViewHeader: TextView
    private lateinit var butonChangePwd: Button
    private lateinit var progressDialog: AlertDialog
    private lateinit var etOldPwd: EditText
    private lateinit var etNewPwd: EditText
    private lateinit var etNewCnfPwd: EditText

    private var oldPassword = ""
    private var newPassword = ""
    private var newConfPassword = ""
    private var authToken = ""

    var TAG = ChangePassword::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        changepwdViewModel =
            ViewModelProvider(this, changepwdViewModelFactory).get(ChangePasswordViewModel::class.java)

        getUserDetails()

        backImgChangePwd = findViewById(R.id.imgIcLeftArrow)
        imgBellIconChangePwd = findViewById(R.id.imgHeaderBellIcon)
        textViewHeader = findViewById(R.id.toolbar_header)
        etOldPwd = findViewById(R.id.et_OldPwd)
        etNewPwd = findViewById(R.id.et_NewPwd)
        etNewCnfPwd = findViewById(R.id.et_ConfirmNewPwd)
        butonChangePwd = findViewById(R.id.changePassword_Button)
        backImgChangePwd.visibility = View.VISIBLE
        imgBellIconChangePwd.visibility = View.GONE
        textViewHeader.visibility = View.VISIBLE
        textViewHeader.text = "Change Password"

        imgBellIconChangePwd.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, NotificationActivity::class.java))
            finish()
        })
        backImgChangePwd.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, DashBoard::class.java))
            finish()
        })

//        bottomNavigationView.setOnNavigationItemSelectedListener {
//            val intent = Intent(this, DashBoard::class.java)
//            intent.putExtra("itemId", it.itemId)
//            startActivity(intent)
//            finish()
//
//            return@setOnNavigationItemSelectedListener true
//        }


        butonChangePwd.setOnClickListener {
            startChangePwd()
        }

        progressDialog = UtilityMethods().showProgressDialog(this)

    }

    private fun getUserDetails() {
        val sharedPrefs = getSharedPreferences(Constants.SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE)
        authToken = sharedPrefs.getString(Constants.SHARED_PREFS_AUTH_TOKEN, "")!!
    }

    private fun startChangePwd() {
        oldPassword = etOldPwd.text.toString()
        newPassword = etNewPwd.text.toString()
        newConfPassword = etNewCnfPwd.text.toString()

        if (oldPassword.isNotEmpty() && newPassword.isNotEmpty() && newConfPassword.isNotEmpty() && newPassword == newConfPassword) {
            CoroutineScope(Dispatchers.IO).launch {
                changepwdViewModel.changepwdUser(authToken, oldPassword, newPassword,  this@ChangePassword)
            }
        } else {
            when {
                oldPassword.isEmpty() -> etOldPwd.error = "Old pwd cannot be empty"
                newPassword.isEmpty() -> etNewPwd.error = "New Password cannot be empty"
                newConfPassword.isEmpty() -> etNewCnfPwd.error = "New Password cannot be empty"
                newPassword != newConfPassword -> showFailedDialog()
            }
        }

    }

    private fun showFailedDialog() {
        val failedDialog =
            UtilityMethods().showFailedDialog(this@ChangePassword, "New password should match with confirm password")
        failedDialog.show()
        val btnClose = failedDialog.findViewById<Button>(R.id.btn_close)
        btnClose!!.setOnClickListener {
            failedDialog.dismiss()
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
            Log.d(TAG, "callFailed: $errorMessage")
            if(progressDialog.isShowing)
                progressDialog.dismiss()
        }
    }

    override fun callSuccess(data: Any) {
        CoroutineScope(Dispatchers.Main).launch {
            if (progressDialog.isShowing)
                progressDialog.dismiss()


            val changePasswordResponse: ChangePasswordResponseModel = data as ChangePasswordResponseModel
            Log.d(TAG, "callSuccess: " + changePasswordResponse.message)

            if (changePasswordResponse.status) {
                val intent = Intent(this@ChangePassword, LoginScreen::class.java)
                startActivity(intent)
                finish()
            } else {
                val failedDialog =
                    UtilityMethods().showFailedDialog(this@ChangePassword, changePasswordResponse.message)
                failedDialog.show()
                val btnClose = failedDialog.findViewById<Button>(R.id.btn_close)
                btnClose!!.setOnClickListener {
                    failedDialog.dismiss()
                }
            }
        }
    }
}