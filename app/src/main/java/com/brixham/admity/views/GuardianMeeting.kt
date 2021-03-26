package com.brixham.admity.views

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.adapters.GuardianCallAdapter
import com.brixham.admity.adapters.GuardianMeetingAdapter
import com.brixham.admity.models.GuardianCallData
import com.brixham.admity.models.GuardianCallModel
import com.brixham.admity.models.GuardianMeetingData
import com.brixham.admity.models.GuardianMeetingModel
import com.brixham.admity.network.NetworkCallback
import com.brixham.admity.utilities.Constants
import com.brixham.admity.utilities.UtilityMethods
import com.brixham.admity.viewmodels.GuardianCallViewModel
import com.brixham.admity.viewmodels.GuardianCallViewModelFactory
import com.brixham.admity.viewmodels.GuardianMeetingViewModel
import com.brixham.admity.viewmodels.GuardianMeetingViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class GuardianMeeting : AppCompatActivity(), KodeinAware, NetworkCallback<Any?> {
    override val kodein by closestKodein()

    private lateinit var guardianMeetingViewModel: GuardianMeetingViewModel
    private val guardianMeetingViewModelFactory : GuardianMeetingViewModelFactory by instance()
    private lateinit var textViewToolbarHeader : TextView
    private lateinit var imageViewBackIcon : ImageView
    private lateinit var imageViewMenuIcon : ImageView
    private lateinit var sharedPreferences : SharedPreferences

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<GuardianMeetingAdapter.ViewHolder>? = null
    private lateinit var recycler_adaptar : RecyclerView

    private var authToken : String = ""
    private var guardianMeetingList : ArrayList<GuardianMeetingData> = ArrayList()
    private lateinit var loadingDialog : AlertDialog

    private var TAG = GuardianMeeting::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guardian_meeting)
        guardianMeetingViewModel = ViewModelProvider(this, guardianMeetingViewModelFactory).get(GuardianMeetingViewModel::class.java)

        sharedPreferences = getSharedPreferences(Constants.SHARED_PREF_FILE_NAME, MODE_PRIVATE)
        authToken = sharedPreferences.getString(Constants.SHARED_PREFS_AUTH_TOKEN, "")!!

        loadingDialog = UtilityMethods().showProgressDialog(this)
        fetchGuardianMeeting()
        setupViews()
    }

    private fun fetchGuardianMeeting() {
        CoroutineScope(Dispatchers.IO).launch {
            guardianMeetingViewModel.getGuardianmeeting(authToken = authToken, this@GuardianMeeting)
        }
    }

    private fun setupViews() {
        textViewToolbarHeader = findViewById(R.id.toolbar_header)

        textViewToolbarHeader.text = getString(R.string.guardian_meeting)
        textViewToolbarHeader.visibility = View.VISIBLE

        imageViewBackIcon = findViewById(R.id.imgIcLeftArrow)
        imageViewBackIcon.visibility = View.VISIBLE
        imageViewBackIcon.setOnClickListener {
            onBackPressed()
        }

        imageViewMenuIcon = findViewById(R.id.imgMenuIcon)
        imageViewMenuIcon.visibility = View.GONE
        recycler_adaptar = findViewById(R.id.recycler_guardian_meeting_list)
        layoutManager = LinearLayoutManager(this)
        recycler_adaptar.layoutManager = layoutManager


        /*adapter = GuardianMeetingAdapter()
        recycler_adaptar.adapter = adapter*/
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun callStarted() {
        CoroutineScope(Dispatchers.Main).launch {
            if(!loadingDialog.isShowing){
                loadingDialog.show()
            }
        }
    }

    override fun callFailed(errorMessage: String) {
        CoroutineScope(Dispatchers.Main).launch {
            if(loadingDialog.isShowing){
                loadingDialog.dismiss()
            }

            Log.e("GuardianMeeting", "callFailed: $errorMessage")
        }
    }

    override fun callSuccess(data: Any) {
        CoroutineScope(Dispatchers.Main).launch {
            if(loadingDialog.isShowing){
                loadingDialog.dismiss()
            }
            val guardianMeetingModel = data as GuardianMeetingModel
            guardianMeetingList.clear()
            guardianMeetingList = guardianMeetingModel.data as ArrayList<GuardianMeetingData>
            adapter = GuardianMeetingAdapter(guardianMeetingList)
            recycler_adaptar.adapter = adapter
            (adapter as GuardianMeetingAdapter).notifyDataSetChanged()
        }
    }
}