package com.brixham.admity.views

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.brixham.admity.R
import com.brixham.admity.models.StudentProfileResponseModel
import com.brixham.admity.network.NetworkCallback
import com.brixham.admity.utilities.Constants
import com.brixham.admity.utilities.UtilityMethods
import com.brixham.admity.viewmodels.StudentProfileViewModel
import com.brixham.admity.viewmodels.StudentProfileViewModelFactory
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class StudentProfile : AppCompatActivity(), KodeinAware, NetworkCallback {
    override val kodein by closestKodein()

    private val studentprofileViewModelFactory: StudentProfileViewModelFactory by instance()
    private lateinit var studentprofileViewModel: StudentProfileViewModel

    private lateinit var backImgStudentProf: ImageView
    private lateinit var imgBellIconStudentProf: ImageView
    private lateinit var textViewHeader: TextView
    private lateinit var progressDialog: AlertDialog

    private lateinit var textViewStudentFullName: TextView
    private lateinit var textViewStudentId: TextView
    private lateinit var textViewStudentGuardianName: TextView
    private lateinit var textViewStudentMobileNo: TextView
    private lateinit var textViewStudentBloodGroop: TextView
    private lateinit var textViewStudentDOB: TextView
    private lateinit var textViewStudentClass: TextView
    private lateinit var textViewStudentRollNO: TextView
    private lateinit var textViewStudentSession: TextView
    private lateinit var textViewStudentGender: TextView
    private lateinit var textViewStudentReligion: TextView
    private lateinit var textViewStudentNationality: TextView
    private lateinit var textViewStudentAdhaarCardNo: TextView
    private lateinit var textViewStudentAddress: TextView
    private lateinit var circleStdProfileImgView : CircleImageView



    private var authToken = "";


    private var TAG = StudentProfile::class.java.simpleName

    private fun getStudentDetails() {
        CoroutineScope(Dispatchers.IO).launch {
            studentprofileViewModel.getStudentProfile(authToken, this@StudentProfile)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_profile)

        studentprofileViewModel = ViewModelProvider(this, studentprofileViewModelFactory).get(StudentProfileViewModel::class.java)

        backImgStudentProf = findViewById(R.id.imgIcLeftArrow)
        imgBellIconStudentProf = findViewById(R.id.imgHeaderBellIcon)
        circleStdProfileImgView = findViewById(R.id.profStudent_circleImg)
        textViewHeader = findViewById(R.id.toolbar_header)
        textViewStudentFullName = findViewById(R.id.student_fullName)
        textViewStudentId = findViewById(R.id.studentprofile_Id)
        textViewStudentGuardianName = findViewById(R.id.studentGuardianName)
        textViewStudentMobileNo = findViewById(R.id.student_contactNo)
        textViewStudentBloodGroop = findViewById(R.id.student_bloodGrp)
        textViewStudentDOB = findViewById(R.id.student_dob)
        textViewStudentClass = findViewById(R.id.student_class)
        textViewStudentRollNO = findViewById(R.id.student_RollNo)
        textViewStudentSession = findViewById(R.id.student_session)
        textViewStudentGender = findViewById(R.id.student_gender)
        textViewStudentReligion = findViewById(R.id.student_religion)
        textViewStudentNationality = findViewById(R.id.student_Nationality)
        textViewStudentAdhaarCardNo = findViewById(R.id.student_adhaarCardNo)
        textViewStudentAddress = findViewById(R.id.student_address)


        backImgStudentProf.visibility = VISIBLE
        imgBellIconStudentProf.visibility = VISIBLE
        textViewHeader.visibility = VISIBLE

        textViewHeader.text = getString(R.string.student_profile)

        imgBellIconStudentProf.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, NotificationActivity::class.java))
            finish()
        })

        backImgStudentProf.setOnClickListener {
            startActivity(Intent(this, DashBoard::class.java))
            finish()
        }
        /*imgBellIconStudentProf.setOnClickListener {
            startActivity(Intent(this, ChangePassword::class.java))
            finish()
        }*/

        progressDialog = UtilityMethods().showProgressDialog(this)
    }

    override fun onStart() {
        super.onStart()
        val sharedPrefs = getSharedPreferences(Constants.SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE)
        authToken = sharedPrefs.getString(Constants.SHARED_PREFS_AUTH_TOKEN, "")!!

        // REMOVE LATER
        authToken = Constants.DEFAULT_AUTH_TOKEN;
        Log.d(TAG, "onStart: $authToken")
        getStudentDetails()
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
        }
    }

    override fun callSuccess(data: Any) {
        CoroutineScope(Dispatchers.Main).launch {
            if (progressDialog.isShowing)
                progressDialog.cancel()

            val studentProfileResponse= data as StudentProfileResponseModel
            Log.d(TAG, "callSuccess: " + studentProfileResponse.message)

            if (studentProfileResponse.status) {
                    displayDetails(studentProfileResponse)

            } else {
                val failedDialog =
                    UtilityMethods().showFailedDialog(this@StudentProfile, studentProfileResponse.message)
                failedDialog.show()
                val btnClose = failedDialog.findViewById<Button>(R.id.btn_close)
                btnClose!!.setOnClickListener {
                    failedDialog.dismiss()
                }
            }
        }
    }

    private fun displayDetails(studentProfileResponse: StudentProfileResponseModel) {

        textViewStudentFullName.text = studentProfileResponse.data.s_fName
        //textViewStudentFullName.text = studentProfileResponse.data.s_lName
        textViewStudentId.text = studentProfileResponse.data.pk_studentId as CharSequence?
        textViewStudentGuardianName.text = studentProfileResponse.data.s_FatherName
        textViewStudentMobileNo.text = studentProfileResponse.data.s_ContactNo
        textViewStudentBloodGroop.text = studentProfileResponse.data.s_BloodGp
        textViewStudentDOB.text = studentProfileResponse.data.s_dob
        textViewStudentClass.text = studentProfileResponse.data.classstudent
        textViewStudentRollNO.text = studentProfileResponse.data.roll_No as CharSequence?
        textViewStudentSession.text = studentProfileResponse.data.session
        textViewStudentGender.text = studentProfileResponse.data.gender
        textViewStudentReligion.text = studentProfileResponse.data.religion
        textViewStudentNationality.text = studentProfileResponse.data.nationality
        textViewStudentAdhaarCardNo.text = studentProfileResponse.data.aadhar_card_no as CharSequence?
        textViewStudentAddress.text = studentProfileResponse.data.s_pAddress
        Glide.with(this).load(studentProfileResponse.data.studentImage).into(circleStdProfileImgView)
    }
}