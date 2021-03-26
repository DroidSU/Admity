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
import com.brixham.admity.adapters.FaqAdapter
import com.brixham.admity.adapters.GuardianCallAdapter
import com.brixham.admity.adapters.TransportAdapter
import com.brixham.admity.models.FAQResponseData
import com.brixham.admity.models.FAQResponseModel
import com.brixham.admity.models.GuardianCallData
import com.brixham.admity.models.GuardianCallModel
import com.brixham.admity.network.NetworkCallback
import com.brixham.admity.utilities.Constants
import com.brixham.admity.utilities.UtilityMethods
import com.brixham.admity.viewmodels.FaqViewModel
import com.brixham.admity.viewmodels.FaqViewModelFactory
import com.brixham.admity.viewmodels.GuardianCallViewModel
import com.brixham.admity.viewmodels.GuardianCallViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class GuardianCall : AppCompatActivity(), KodeinAware, NetworkCallback<Any?> {
    override val kodein by closestKodein()

    private lateinit var guardianCallViewModel: GuardianCallViewModel
    private val guardianCallViewModelFactory : GuardianCallViewModelFactory by instance()
    private lateinit var textViewToolbarHeader : TextView
    private lateinit var imageViewBackIcon : ImageView
    private lateinit var imageViewMenuIcon : ImageView
    private lateinit var sharedPreferences : SharedPreferences

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<GuardianCallAdapter.ViewHolder>? = null
    private lateinit var recycler_adaptar : RecyclerView

    private var authToken : String = ""
    private var guardianCallList : ArrayList<GuardianCallData> = ArrayList()
    private lateinit var loadingDialog : AlertDialog

    private var TAG = GuardianCall::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guardian_call)
        guardianCallViewModel = ViewModelProvider(this, guardianCallViewModelFactory).get(GuardianCallViewModel::class.java)
        setupViews()

        sharedPreferences = getSharedPreferences(Constants.SHARED_PREF_FILE_NAME, MODE_PRIVATE)
        authToken = sharedPreferences.getString(Constants.SHARED_PREFS_AUTH_TOKEN, "")!!

        loadingDialog = UtilityMethods().showProgressDialog(this)
        fetchGuardianCall()
    }

    private fun fetchGuardianCall() {
        CoroutineScope(Dispatchers.IO).launch {
            guardianCallViewModel.getGuardiancall(authToken = authToken, this@GuardianCall)
        }
    }

    private fun setupViews() {
        textViewToolbarHeader = findViewById(R.id.toolbar_header)

        textViewToolbarHeader.text = getString(R.string.guardian_call)
        textViewToolbarHeader.visibility = View.VISIBLE

        imageViewBackIcon = findViewById(R.id.imgIcLeftArrow)
        imageViewBackIcon.visibility = View.VISIBLE
        imageViewBackIcon.setOnClickListener {
            onBackPressed()
        }

        imageViewMenuIcon = findViewById(R.id.imgMenuIcon)
        imageViewMenuIcon.visibility = View.GONE
        recycler_adaptar = findViewById(R.id.recycler_guardian_list)
        layoutManager = LinearLayoutManager(this)
        recycler_adaptar.layoutManager = layoutManager


        /*adapter = GuardianCallAdapter()
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

            Log.e("GuardianCall", "callFailed: $errorMessage")
        }
    }

    override fun callSuccess(data: Any) {
        CoroutineScope(Dispatchers.Main).launch {
            if(loadingDialog.isShowing){
                loadingDialog.dismiss()
            }
            val guardianCallModel = data as GuardianCallModel
            guardianCallList.clear()
            guardianCallList = guardianCallModel.data as ArrayList<GuardianCallData>
            adapter = GuardianCallAdapter(guardianCallList)
            recycler_adaptar.adapter = adapter
            (adapter as GuardianCallAdapter).notifyDataSetChanged()
        }
    }
}