package com.brixham.admity.views

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.adapters.HolidayAdapter
import com.brixham.admity.models.HolidayResponseData
import com.brixham.admity.models.HolidayResponseModel
import com.brixham.admity.network.NetworkCallback
import com.brixham.admity.utilities.Constants
import com.brixham.admity.utilities.UtilityMethods
import com.brixham.admity.viewmodels.HolidayViewModel
import com.brixham.admity.viewmodels.HolidayViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class HolidayActivity : AppCompatActivity(), KodeinAware, NetworkCallback {
    override val kodein by closestKodein()

    private val holidayViewModelFactory: HolidayViewModelFactory  by instance()
    private lateinit var holidayViewModel: HolidayViewModel

    private lateinit var imageViewBackButton: ImageView
    private lateinit var imgHolidayBellIcon: ImageView
    private lateinit var textViewHeader: TextView
    private lateinit var progressDialog: AlertDialog
    private lateinit var toolbar : Toolbar

    private var layoutManager: RecyclerView.LayoutManager? = null
    private lateinit var adapter : HolidayAdapter
    private lateinit var recyclerView : RecyclerView

    private var authToken = ""
    private var holidayList : List<HolidayResponseData> = ArrayList()


    private var TAG = HolidayActivity::class.java.simpleName

    private fun getHoliday() {
        CoroutineScope(Dispatchers.IO).launch {
            holidayViewModel.getHoliday(authToken, this@HolidayActivity)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_holiday)

        toolbar = findViewById(R.id.holiday_toolbar)
        setSupportActionBar(toolbar)

        holidayViewModel = ViewModelProvider(this, holidayViewModelFactory).get(HolidayViewModel::class.java)


        imageViewBackButton = findViewById(R.id.imgIcLeftArrow)
        imageViewBackButton.visibility = View.VISIBLE
        imageViewBackButton.setOnClickListener {
            finish()
        }

        imgHolidayBellIcon = findViewById(R.id.imgHeaderBellIcon)
        textViewHeader = findViewById(R.id.toolbar_header)
        textViewHeader.text = "Holiday"

        recyclerView = findViewById(R.id.recycler_holiday)

        imgHolidayBellIcon.visibility = View.GONE
        textViewHeader.visibility = View.VISIBLE

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        progressDialog = UtilityMethods().showProgressDialog(this)
    }



    override fun onStart() {
        super.onStart()
        val sharedPrefs = getSharedPreferences(Constants.SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE)
        authToken = sharedPrefs.getString(Constants.SHARED_PREFS_AUTH_TOKEN, "")!!

        getHoliday()
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

            val holidayResponse= data as HolidayResponseModel
            Log.d(TAG, "callSuccess: " + holidayResponse.message)

            if (holidayResponse.status) {
                holidayList = holidayResponse.data
                displayHolidayDetails(holidayResponse)
            } else {
                val failedDialog =
                    UtilityMethods().showFailedDialog(this@HolidayActivity, holidayResponse.message)
                failedDialog.show()
                val btnClose = failedDialog.findViewById<Button>(R.id.btn_close)
                btnClose!!.setOnClickListener {
                    failedDialog.dismiss()
                }
            }
        }
    }

    private fun displayHolidayDetails(holidayResponse: HolidayResponseModel) {
        adapter = HolidayAdapter(this, holidayResponse.data)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }


}