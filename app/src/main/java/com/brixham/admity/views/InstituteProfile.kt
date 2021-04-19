package com.brixham.admity.views

import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.brixham.admity.R
import com.brixham.admity.models.InstituteProfileModel
import com.brixham.admity.network.NetworkCallback
import com.brixham.admity.utilities.Constants
import com.brixham.admity.utilities.UtilityMethods
import com.brixham.admity.viewmodels.InstituteProfileViewModel
import com.brixham.admity.viewmodels.InstituteProfileViewModelFactory
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance
import java.util.jar.Manifest


class InstituteProfile : AppCompatActivity(), KodeinAware, NetworkCallback<Any?>,
    OnMapReadyCallback {
    override val kodein by closestKodein()

    private val instituteProfileViewModelFactory: InstituteProfileViewModelFactory by instance()
    private lateinit var instituteProfileViewModel: InstituteProfileViewModel

    private lateinit var textViewToolbarHeader : TextView
    private lateinit var imageViewBackIcon : ImageView
    private lateinit var imageViewMenuIcon : ImageView
    private lateinit var progressDialog: AlertDialog

    private lateinit var instituteProfWelcomeNote: TextView
    private lateinit var instituteProfImage: ImageView
    private lateinit var instituteProfDescription: TextView
    private lateinit var instituteProfName: TextView
    private lateinit var instituteProfUniversityName: TextView
    private lateinit var instituteProfWebsite: TextView
    private lateinit var instituteProfAddress: TextView
    private lateinit var instituteProfDomainName: TextView
    private lateinit var instituteProfEstd: TextView
    private lateinit var instituteProfPhoneNo: TextView
    private lateinit var instituteProfPrinciplePhoneNo: TextView
    private lateinit var instituteProfEmailId: TextView
    private lateinit var instituteProfPrincipleEmailId: TextView
    private lateinit var instituteProfType: TextView
    private lateinit var instituteProfAuthorityType: TextView
    private lateinit var instituteProfDistanceEdu: TextView
    private lateinit var instituteProfOnlineEdu: TextView
    private lateinit var instituteProfSessionAvailability: TextView
    private lateinit var instituteProfAdmissionType: TextView
    private lateinit var instituteProfPaymentType: TextView
    private lateinit var instituteProfFeesType: TextView
    private lateinit var instituteProfCategory: TextView
    private lateinit var instituteProfLab: TextView
    private lateinit var instituteProfLbrary: TextView
    private lateinit var instituteProfHostel: TextView
    private lateinit var instituteProfMeal: TextView
    private lateinit var instituteProfTransport: TextView
    private lateinit var instituteProfAboutUs: TextView

    private lateinit var instituteProfFacebookImage: ImageView
    private lateinit var instituteProfGoogleImage: ImageView
    private lateinit var instituteProfLinkedinImage: ImageView
    private lateinit var instituteProfTwitterImage: ImageView

    private lateinit var mapFragment: Fragment
    //private var uri = "geo:0,0?q=india"
    private var authToken = "";
    private var lattitude = 0.0;
    private var longitude = 0.0;

    private lateinit var map: GoogleMap
    var lm: LocationManager? = null
    var ll: LocationListener? = null
    var l: Location? = null



    var pos: LatLng? = null

    private var TAG = InstituteProfile::class.java.simpleName

    private fun getInstituteProfileDetails() {
        CoroutineScope(Dispatchers.IO).launch {
            instituteProfileViewModel.getInstituteProfile(authToken, this@InstituteProfile)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_institute_profile)
        instituteProfileViewModel = ViewModelProvider(this, instituteProfileViewModelFactory).get(
            InstituteProfileViewModel::class.java
        )
        setupViews()
        progressDialog = UtilityMethods().showProgressDialog(this)

        //getLocation()

        /*val mapFragment: SupportMapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)*/

    }

    /*private fun getLocation() {
        lm = this.getSystemService(LOCATION_SERVICE) as LocationManager?
        ll = object : LocationListener {
            override fun onLocationChanged(location: Location) {
                l = location as Location?
                lattitude = location.latitude
                longitude = location.longitude
            }

            override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
            override fun onProviderEnabled(provider: String) {}
            override fun onProviderDisabled(provider: String) {}
        }
    }*/

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

//        if (ContextCompat.checkSelfPermission(
//                this,
//               android.Manifest.permission.ACCESS_FINE_LOCATION
//            ) == PackageManager.PERMISSION_GRANTED
//        ) {
//            lm!!.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0f, ll!!)
//        }
//        pos = l?.let { LatLng(it.getLatitude(), l!!.getLongitude()) }
//
//        // Add a marker in Sydney and move the camera
//        map?.setMyLocationEnabled(true)
//        map?.addMarker(pos?.let { MarkerOptions().position(it).title("Marker in Sydney") })
//        map?.moveCamera(CameraUpdateFactory.newLatLng(pos))
    }

    private fun setupViews() {
        textViewToolbarHeader = findViewById(R.id.toolbar_header)

        textViewToolbarHeader.text = getString(R.string.institute_profile)
        textViewToolbarHeader.visibility = View.VISIBLE

        imageViewBackIcon = findViewById(R.id.imgIcLeftArrow)
        imageViewBackIcon.visibility = View.VISIBLE
        imageViewBackIcon.setOnClickListener {
            onBackPressed()
        }

        imageViewMenuIcon = findViewById(R.id.imgMenuIcon)
        imageViewMenuIcon.visibility = View.GONE

        instituteProfWelcomeNote = findViewById(R.id.instituteProfile_welcome_note)
        instituteProfImage = findViewById(R.id.instituteProfile_image)
        instituteProfDescription = findViewById(R.id.instituteProfile_description)
        instituteProfName = findViewById(R.id.institute_name)
        instituteProfUniversityName = findViewById(R.id.institute_university_name)
        instituteProfWebsite = findViewById(R.id.institute_website)
        instituteProfAddress = findViewById(R.id.institute_address)
        instituteProfDomainName = findViewById(R.id.institute_domain_name)
        instituteProfEstd = findViewById(R.id.institute_estd)
        instituteProfPhoneNo = findViewById(R.id.institute_phone_no)
        instituteProfPrinciplePhoneNo = findViewById(R.id.institute_principle_ph_no)
        instituteProfEmailId = findViewById(R.id.institute_email_id)
        instituteProfPrincipleEmailId = findViewById(R.id.institute_principle_email_id)
        instituteProfType = findViewById(R.id.institute_type)
        instituteProfAuthorityType = findViewById(R.id.institute_authority_type)
        instituteProfDistanceEdu = findViewById(R.id.institute_distance_name)
        instituteProfOnlineEdu = findViewById(R.id.institute_online_education)
        instituteProfSessionAvailability = findViewById(R.id.institute_session_availabilty)
        instituteProfAdmissionType = findViewById(R.id.institute_admission_type)
        instituteProfPaymentType = findViewById(R.id.institute_payent_mode)
        instituteProfFeesType = findViewById(R.id.institute_fees_type)
        instituteProfCategory = findViewById(R.id.institute_category)
        instituteProfLab = findViewById(R.id.institute_lab_available)
        instituteProfLbrary = findViewById(R.id.institute_library_available)
        instituteProfHostel = findViewById(R.id.institute_hostel_available)
        instituteProfMeal = findViewById(R.id.institute_meal_available)
        instituteProfTransport = findViewById(R.id.institute_transport_availble)
        instituteProfAboutUs = findViewById(R.id.instituteProfile_aboutUs)
        instituteProfFacebookImage = findViewById(R.id.instituteProfile_facebook)
        instituteProfGoogleImage = findViewById(R.id.instituteProfile_google)
        instituteProfLinkedinImage = findViewById(R.id.instituteProfile_linkedin)
        instituteProfTwitterImage = findViewById(R.id.instituteProfile_twitter)


        //mapFragment = supportFragmentManager.findFragmentById(R.id.map)!!




        /*mapFragment.setOnClickListener {
            *//*var uriIntent:Uri = Uri.parse(uri)
            var intent: Intent = Intent(Intent.ACTION_VIEW, uriIntent)
            intent.setPackage("com.google.android.apps.maps")
            if (intent.resolveActivity(packageManager) != null){
                startActivity(intent)
            }*//*
        }*/
    }

    override fun onStart() {
        super.onStart()
        val sharedPrefs = getSharedPreferences(
            Constants.SHARED_PREF_FILE_NAME,
            Context.MODE_PRIVATE
        )
        authToken = sharedPrefs.getString(Constants.SHARED_PREFS_AUTH_TOKEN, "")!!

        // REMOVE LATER
        authToken = Constants.DEFAULT_AUTH_TOKEN;
        Log.d(TAG, "onStart: $authToken")
        getInstituteProfileDetails()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
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

            val instituteProfileModel= data as InstituteProfileModel
            Log.d(TAG, "callSuccess: " + instituteProfileModel.message)

            if (instituteProfileModel.status) {
                displayInstituteDetails(instituteProfileModel)

            } else {
                val failedDialog =
                    UtilityMethods().showFailedDialog(
                        this@InstituteProfile,
                        instituteProfileModel.message
                    )
                failedDialog.show()
                val btnClose = failedDialog.findViewById<Button>(R.id.btn_close)
                btnClose!!.setOnClickListener {
                    failedDialog.dismiss()
                }
            }
        }
    }

    private fun displayInstituteDetails(instituteProfileModel: InstituteProfileModel) {
        instituteProfWelcomeNote.text = instituteProfileModel.data.welcomeNote
        instituteProfDescription.text = instituteProfileModel.data.instituteDescription
        instituteProfName.text = instituteProfileModel.data.instituteName as CharSequence?
        instituteProfUniversityName.text = instituteProfileModel.data.universityName
        instituteProfWebsite.text  = instituteProfileModel.data.websiteURL as CharSequence?
        instituteProfAddress.text = instituteProfileModel.data.instituteAddress
        instituteProfDomainName.text = instituteProfileModel.data.domain_Name as CharSequence?
        instituteProfEstd.text = instituteProfileModel.data.estd
        instituteProfPhoneNo.text = instituteProfileModel.data.institutePhone_one
        instituteProfPrinciplePhoneNo.text = instituteProfileModel.data.institutePhone_two
        instituteProfEmailId.text = instituteProfileModel.data.instituteEmail_one
        instituteProfPrincipleEmailId.text = instituteProfileModel.data.principalEmail as CharSequence?
        instituteProfType.text = instituteProfileModel.data.institute_Type as CharSequence?
        instituteProfAuthorityType.text = instituteProfileModel.data.authority_Type as CharSequence?
        instituteProfDistanceEdu.text = instituteProfileModel.data.distance_Education as CharSequence?
        instituteProfOnlineEdu.text = instituteProfileModel.data.online_Education as CharSequence?
        instituteProfSessionAvailability.text = instituteProfileModel.data.session_Availibility as CharSequence?
        instituteProfAdmissionType.text = instituteProfileModel.data.admission_Type as CharSequence?
        instituteProfPaymentType.text = instituteProfileModel.data.payment_Mode as CharSequence?
        instituteProfFeesType.text = instituteProfileModel.data.fees_Type as CharSequence?
        instituteProfCategory.text = instituteProfileModel.data.category
        instituteProfLab.text = instituteProfileModel.data.computer_Lab
        instituteProfLbrary.text = instituteProfileModel.data.libery_Availibility
        instituteProfHostel.text = instituteProfileModel.data.hostel_Availibility
        instituteProfMeal.text = instituteProfileModel.data.meal_Availibility
        instituteProfTransport.text = instituteProfileModel.data.transport_Availibility
        instituteProfAboutUs.text = instituteProfileModel.data.institute_Short_About_Us
        //Glide.with(this).load(instituteProfileModel.data.ins_photo).into(instituteProfImage)
        /*Glide.with(this).load(instituteProfileModel.data.facebookURL).into(instituteProfFacebookImage)
        Glide.with(this).load(instituteProfileModel.data.googlePlusURL).into(instituteProfGoogleImage)
        Glide.with(this).load(instituteProfileModel.data.twitterURL).into(instituteProfTwitterImage)
        Glide.with(this).load(instituteProfileModel.data.linkedINURL).into(instituteProfLinkedinImage)*/

    }
}





