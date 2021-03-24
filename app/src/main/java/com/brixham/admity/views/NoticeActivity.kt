package com.brixham.admity.views

import android.content.Intent
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
import com.brixham.admity.adapters.NoticeAdapter
import com.brixham.admity.adapters.RecycleProspectAdapter
import com.brixham.admity.models.MyPropectusData
import com.brixham.admity.models.MyProspectusModel
import com.brixham.admity.models.NoticeResponseData
import com.brixham.admity.models.NoticeResponseModel
import com.brixham.admity.network.NetworkCallback
import com.brixham.admity.utilities.Constants
import com.brixham.admity.utilities.UtilityMethods
import com.brixham.admity.viewmodels.MyProspectusViewModel
import com.brixham.admity.viewmodels.MyProspectusViewModelFactory
import com.brixham.admity.viewmodels.NoticeViewModel
import com.brixham.admity.viewmodels.NoticeViewModelFactory
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance
import java.text.SimpleDateFormat

class NoticeActivity : AppCompatActivity(), KodeinAware, NetworkCallback {
    override val kodein by closestKodein()

    private lateinit var noticeViewModel: NoticeViewModel
    private val noticeViewModelFactory : NoticeViewModelFactory by instance()
    private lateinit var recyclerView: RecyclerView
    private var layoutManager: RecyclerView.LayoutManager? = null
    private lateinit var adapter: NoticeAdapter
    private lateinit var sharedPreferences : SharedPreferences
    private lateinit var backImgNotice: ImageView
    private lateinit var imgNoticeViewBellIcon: ImageView
    private lateinit var textViewHeader: TextView
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var dateFormat: SimpleDateFormat

    private var authToken : String = ""
    private var noticeList : ArrayList<NoticeResponseData> = ArrayList()
    private lateinit var loadingDialog : AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notice)
        noticeViewModel = ViewModelProvider(this, noticeViewModelFactory).get(NoticeViewModel::class.java)
        setupView()
        sharedPreferences = getSharedPreferences(Constants.SHARED_PREF_FILE_NAME, MODE_PRIVATE)
        authToken = sharedPreferences.getString(Constants.SHARED_PREFS_AUTH_TOKEN, "")!!

        loadingDialog = UtilityMethods().showProgressDialog(this)

        fetchNotice()
        bottomNavigationView = findViewById(R.id.notice_bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            val intent = Intent(this, DashBoard::class.java)
            intent.putExtra("itemId", it.itemId)
            startActivity(intent)
            finish()

            return@setOnNavigationItemSelectedListener true
        }


    }

    private fun fetchNotice() {
        CoroutineScope(Dispatchers.IO).launch {
            noticeViewModel.getNotice(authToken = authToken, this@NoticeActivity)
        }
    }

    private fun setupView() {
        backImgNotice = findViewById(R.id.imgIcLeftArrow)
        imgNoticeViewBellIcon = findViewById(R.id.imgHeaderBellIcon)
        textViewHeader = findViewById(R.id.toolbar_header)
        recyclerView = findViewById(R.id.notice_recyclerView)
        textViewHeader.text = getString(R.string.notices)
        backImgNotice.visibility = View.VISIBLE
        textViewHeader.visibility = View.VISIBLE
        imgNoticeViewBellIcon.visibility = View.VISIBLE

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        backImgNotice.setOnClickListener {
            var intent: Intent = Intent(this, DashBoard::class.java)
            intent.putExtra("itemId", R.id.buttonHome)
            startActivity(intent)
            finish()
        }
        imgNoticeViewBellIcon.setOnClickListener {
            var intent: Intent = Intent(this, NotificationActivity::class.java)
            startActivity(intent)
            finish()
        }
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

            Log.e("Notice", "callFailed: $errorMessage")
        }
    }

    override fun callSuccess(data: Any) {
        CoroutineScope(Dispatchers.Main).launch {
            if(loadingDialog.isShowing){
                loadingDialog.dismiss()
            }
            val noticeResponse = data as NoticeResponseModel
            noticeList.clear()
            noticeList = noticeResponse.data as ArrayList<NoticeResponseData>
            adapter = NoticeAdapter(noticeList)
            recyclerView.adapter = adapter

            adapter.notifyDataSetChanged()
        }
    }
}