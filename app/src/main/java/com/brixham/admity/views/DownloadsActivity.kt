package com.brixham.admity.views

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.brixham.admity.R
import com.brixham.admity.adapters.DownloadsGridAdapter
import com.brixham.admity.models.*
import com.brixham.admity.network.NetworkCallback
import com.brixham.admity.utilities.Constants
import com.brixham.admity.utilities.UtilityMethods
import com.brixham.admity.viewmodels.DownloadViewModel
import com.brixham.admity.viewmodels.DownloadViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class DownloadsActivity : AppCompatActivity(), KodeinAware, NetworkCallback<Any?> {
    override val kodein by closestKodein()

    private lateinit var downloadViewModel: DownloadViewModel
    private val downloadViewModelFactory : DownloadViewModelFactory by instance()
    private lateinit var downloadGridView: GridView

    private lateinit var textViewToolbarHeader : TextView
    private lateinit var imageViewBackIcon : ImageView
    private lateinit var imageViewMenuIcon : ImageView
    private lateinit var sharedPreferences : SharedPreferences

    private lateinit var downloadGridAdapter : DownloadsGridAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var staggeredGridLayoutManager: StaggeredGridLayoutManager
    private var layoutManager: RecyclerView.LayoutManager? = null

    private var authToken : String = ""
    private var downloadList : ArrayList<DownloadResponseData> = ArrayList()
    private lateinit var loadingDialog : AlertDialog

    private var TAG = DownloadsActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_downloads_acitivity)

        downloadViewModel = ViewModelProvider(this, downloadViewModelFactory).get(DownloadViewModel::class.java)

        sharedPreferences = getSharedPreferences(Constants.SHARED_PREF_FILE_NAME, MODE_PRIVATE)
        authToken = sharedPreferences.getString(Constants.SHARED_PREFS_AUTH_TOKEN, "")!!

        loadingDialog = UtilityMethods().showProgressDialog(this)
        fetchDownload()



        //downloadGridAdapter = DownloadsGridAdapter(this, R.layout.download_layout_list, listOfDownloadGridModels)


        setupViews()
        initGridModules()
    }

    private fun fetchDownload() {
        CoroutineScope(Dispatchers.IO).launch {
            downloadViewModel.getDownloads(authToken = authToken, this@DownloadsActivity)
        }
    }

    private fun initGridModules() {


            //listOfDownloadGridModels.add(DownloadGridModel("Download details","Download title", R.drawable.ic_download))


    }

    private fun setupViews() {
        textViewToolbarHeader = findViewById(R.id.toolbar_header)
        textViewToolbarHeader.visibility = VISIBLE
        textViewToolbarHeader.text = resources.getString(R.string.downloads)

        imageViewBackIcon = findViewById(R.id.imgIcLeftArrow)
        imageViewBackIcon.visibility = VISIBLE
        imageViewBackIcon.setOnClickListener {
            onBackPressed()
        }

        imageViewMenuIcon = findViewById(R.id.imgMenuIcon)
        imageViewMenuIcon.visibility = GONE
        recyclerView = findViewById(R.id.download_recyclerView)
        layoutManager = LinearLayoutManager(this)
        //recyclerView.layoutManager = layoutManager
        staggeredGridLayoutManager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
        recyclerView.layoutManager = staggeredGridLayoutManager

        /*downloadGridAdapter = DownloadsGridAdapter(this, R.layout.download_layout_list, downloadList)
        downloadGridView.adapter = downloadGridAdapter*/
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

            Log.e("Downloads", "callFailed: $errorMessage")
        }
    }

    override fun callSuccess(data: Any) {
        CoroutineScope(Dispatchers.Main).launch {
            if(loadingDialog.isShowing){
                loadingDialog.dismiss()
            }
            val downloadResponseModel = data as DownloadResponseModel
            downloadList.clear()
            downloadList = downloadResponseModel.data as ArrayList<DownloadResponseData>
            //downloadGridAdapter = DownloadsGridAdapter(this@DownloadsActivity, R.layout.download_layout_list, downloadList)
            downloadGridAdapter = DownloadsGridAdapter(downloadList, downloadViewModel)
            recyclerView.adapter = downloadGridAdapter


            downloadGridAdapter.notifyDataSetChanged()



        }

    }
}