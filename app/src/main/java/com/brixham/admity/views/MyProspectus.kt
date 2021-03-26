package com.brixham.admity.views

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ExpandableListView
import android.widget.ImageView
import android.widget.TextView

import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.adapters.RecycleProspectAdapter
import com.brixham.admity.models.MyPropectusData
import com.brixham.admity.models.MyProspectusModel
import com.brixham.admity.network.NetworkCallback
import com.brixham.admity.utilities.Constants
import com.brixham.admity.utilities.UtilityMethods
import com.brixham.admity.viewmodels.MyProspectusViewModel
import com.brixham.admity.viewmodels.MyProspectusViewModelFactory
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class MyProspectus: AppCompatActivity(), KodeinAware, NetworkCallback<Any?> {

    override val kodein by closestKodein()


    private lateinit var myProspectusViewModel: MyProspectusViewModel
    private val myProspectusViewModelFactory : MyProspectusViewModelFactory by instance()
    private var expandableListView: ExpandableListView? = null
    //private var adapter: ExpandableListAdapter? = null
    private var titleList: List<String> ? = null
    private lateinit var imageBackPropectus: ImageView
    private lateinit var textViewHeader: TextView
    private lateinit var sharedPreferences : SharedPreferences
    private lateinit var recyclerView: RecyclerView
    private var layoutManager: RecyclerView.LayoutManager? = null
    private lateinit var adapter: RecycleProspectAdapter
    private lateinit var bottomNavigationView: BottomNavigationView


    private var authToken : String = ""
    private var prospectusList : ArrayList<MyPropectusData> = ArrayList()
    private lateinit var loadingDialog : AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_prospectus)

      myProspectusViewModel = ViewModelProvider(this, myProspectusViewModelFactory).get(MyProspectusViewModel::class.java)
        //expandableListView = findViewById(R.id.myprospectus_expandablelistView)

        setupView()
        sharedPreferences = getSharedPreferences(Constants.SHARED_PREF_FILE_NAME, MODE_PRIVATE)
        authToken = sharedPreferences.getString(Constants.SHARED_PREFS_AUTH_TOKEN, "")!!

        loadingDialog = UtilityMethods().showProgressDialog(this)

        fetchNotifications()
        bottomNavigationView = findViewById(R.id.prospectus_bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            val intent = Intent(this, DashBoard::class.java)
            intent.putExtra("itemId", it.itemId)
            startActivity(intent)
            finish()

            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun fetchNotifications() {
        CoroutineScope(Dispatchers.IO).launch {
            myProspectusViewModel.getProspectus(authToken = authToken, this@MyProspectus)
        }
    }

    private fun setupView() {
        textViewHeader = findViewById(R.id.toolbar_header)
        imageBackPropectus = findViewById(R.id.imgIcLeftArrow)
        recyclerView = findViewById(R.id.myprospectus_recyclerView)
        imageBackPropectus.visibility = View.VISIBLE
        textViewHeader.visibility = View.VISIBLE
        textViewHeader.text = getString(R.string.my_prospectus)

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        imageBackPropectus.setOnClickListener {
            val intent = Intent(this, DashBoard::class.java)
            intent.putExtra("itemId", R.id.buttonHome)
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

            Log.e("Prospectus", "callFailed: $errorMessage")
        }
    }

    override fun callSuccess(data: Any) {
        CoroutineScope(Dispatchers.Main).launch {
            if(loadingDialog.isShowing){
                loadingDialog.dismiss()
            }
            val prospectusResponse = data as MyProspectusModel
            prospectusList.clear()
            prospectusList = prospectusResponse.data as ArrayList<MyPropectusData>
            adapter = RecycleProspectAdapter(prospectusList)
            recyclerView.adapter = adapter

            adapter.notifyDataSetChanged()
        }
    }

}
