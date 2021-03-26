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
import com.brixham.admity.adapters.FaqAdapter
import com.brixham.admity.adapters.NoticeAdapter
import com.brixham.admity.models.FAQResponseData
import com.brixham.admity.models.FAQResponseModel
import com.brixham.admity.models.NoticeResponseData
import com.brixham.admity.models.NoticeResponseModel
import com.brixham.admity.network.NetworkCallback
import com.brixham.admity.utilities.Constants
import com.brixham.admity.utilities.UtilityMethods
import com.brixham.admity.viewmodels.FaqViewModel
import com.brixham.admity.viewmodels.FaqViewModelFactory
import com.brixham.admity.viewmodels.NoticeViewModel
import com.brixham.admity.viewmodels.NoticeViewModelFactory
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class FAQActivity : AppCompatActivity(), KodeinAware, NetworkCallback<Any?> {
    override val kodein by closestKodein()

    private lateinit var faqViewModel: FaqViewModel
    private val faqViewModelFactory : FaqViewModelFactory by instance()
    private lateinit var recyclerView: RecyclerView
    private var layoutManager: RecyclerView.LayoutManager? = null
    private lateinit var adapter: FaqAdapter
    private lateinit var sharedPreferences : SharedPreferences
    private lateinit var backImgFAQ: ImageView
    private lateinit var imgFAQBellIcon: ImageView
    private lateinit var textViewHeader: TextView
    private lateinit var bottomNavigationView: BottomNavigationView

    private var authToken : String = ""
    private var faqList : ArrayList<FAQResponseData> = ArrayList()
    private lateinit var loadingDialog : AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_f_a_q)
        faqViewModel = ViewModelProvider(this, faqViewModelFactory).get(FaqViewModel::class.java)
        setupView()

        sharedPreferences = getSharedPreferences(Constants.SHARED_PREF_FILE_NAME, MODE_PRIVATE)
        authToken = sharedPreferences.getString(Constants.SHARED_PREFS_AUTH_TOKEN, "")!!

        loadingDialog = UtilityMethods().showProgressDialog(this)
        fetchFaqs()
    }

    private fun fetchFaqs() {
        CoroutineScope(Dispatchers.IO).launch {
            faqViewModel.getFaq(authToken = authToken, this@FAQActivity)
        }
    }

    private fun setupView() {
        backImgFAQ = findViewById(R.id.imgIcLeftArrow)
        imgFAQBellIcon = findViewById(R.id.imgHeaderBellIcon)
        textViewHeader = findViewById(R.id.toolbar_header)
        bottomNavigationView = findViewById(R.id.faq_bottom_navigation)
        recyclerView = findViewById(R.id.faq_recyclerView)

        textViewHeader.text = getString(R.string.faq)
        backImgFAQ.visibility = View.VISIBLE
        textViewHeader.visibility = View.VISIBLE

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        backImgFAQ.setOnClickListener {
            var intent: Intent = Intent(this, DashBoard::class.java)
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
        /*imgNoticeViewBellIcon.setOnClickListener {
            var intent: Intent = Intent(this, NotificationActivity::class.java)
            startActivity(intent)
            finish()
        }*/
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

            Log.e("Faq", "callFailed: $errorMessage")
        }
    }

    override fun callSuccess(data: Any) {
        CoroutineScope(Dispatchers.Main).launch {
            if(loadingDialog.isShowing){
                loadingDialog.dismiss()
            }
            val faqResponseModel = data as FAQResponseModel
            faqList.clear()
            faqList = faqResponseModel.data as ArrayList<FAQResponseData>
            adapter = FaqAdapter(faqList)
            recyclerView.adapter = adapter

            adapter.notifyDataSetChanged()
        }
    }
}