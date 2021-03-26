package com.brixham.admity.views

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.adapters.NotificationsRecyclerAdapter
import com.brixham.admity.adapters.RecyclerAdapter
import com.brixham.admity.fragments.HelpFragment
import com.brixham.admity.models.NotificationsResponseData
import com.brixham.admity.models.NotificationsResponseModel
import com.brixham.admity.network.NetworkCallback
import com.brixham.admity.utilities.Constants
import com.brixham.admity.utilities.UtilityMethods
import com.brixham.admity.viewmodels.NotificationsViewModel
import com.brixham.admity.viewmodels.NotificationsViewModelFactory
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class NotificationActivity : AppCompatActivity(), KodeinAware, NetworkCallback<Any?> {

    override val kodein by closestKodein()

    private var layoutManager: RecyclerView.LayoutManager? = null
    private lateinit var adapter: NotificationsRecyclerAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var imageBackNotification: ImageView
    private lateinit var textViewHeader: TextView
    private lateinit var notificationsViewModel : NotificationsViewModel
    private val notificationsViewModelFactory : NotificationsViewModelFactory by instance()
    private lateinit var sharedPreferences : SharedPreferences
    private lateinit var bottomNavigationView : BottomNavigationView

    private var authToken : String = ""
    private var notificationsList : ArrayList<NotificationsResponseData> = ArrayList()
    private lateinit var loadingDialog : AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        notificationsViewModel = ViewModelProvider(this, notificationsViewModelFactory).get(NotificationsViewModel::class.java)

        setupView()

        sharedPreferences = getSharedPreferences(Constants.SHARED_PREF_FILE_NAME, MODE_PRIVATE)
        authToken = sharedPreferences.getString(Constants.SHARED_PREFS_AUTH_TOKEN, "")!!

        loadingDialog = UtilityMethods().showProgressDialog(this)

        fetchNotifications()
    }

    private fun fetchNotifications() {
        CoroutineScope(Dispatchers.IO).launch {
            notificationsViewModel.getNotifications(authToken = authToken, this@NotificationActivity)
        }
    }

    private fun setupView() {
        textViewHeader = findViewById(R.id.toolbar_header)
        recyclerView = findViewById(R.id.recyclerNotification)
        imageBackNotification = findViewById(R.id.imgIcLeftArrow)
        bottomNavigationView = findViewById(R.id.notification_bottom_navigation)

        imageBackNotification.visibility = View.VISIBLE
        textViewHeader.visibility = View.VISIBLE
        textViewHeader.text = resources.getString(R.string.notification)

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        imageBackNotification.setOnClickListener {
            val intent = Intent(this, DashBoard::class.java)
            intent.putExtra("itemId", R.id.buttonHome)
            startActivity(intent)
            finish()
        }

        bottomNavigationView.setOnNavigationItemSelectedListener {
            val intent = Intent(this, DashBoard::class.java)
            intent.putExtra("itemId", it.itemId)
            startActivity(intent)
            finish()

            return@setOnNavigationItemSelectedListener true
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

            Log.e("Notifications", "callFailed: $errorMessage")
        }
    }

    override fun callSuccess(data: Any) {
        CoroutineScope(Dispatchers.Main).launch {
            if(loadingDialog.isShowing){
                loadingDialog.dismiss()
            }

            val notificationsResponse = data as NotificationsResponseModel
            notificationsList.clear()
            notificationsList = notificationsResponse.data
            adapter = NotificationsRecyclerAdapter(notificationsList)
            recyclerView.adapter = adapter

            adapter.notifyDataSetChanged()
        }
    }
}