package com.brixham.admity.adapters

import android.content.BroadcastReceiver
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.models.DownloadResponseData
import com.brixham.admity.network.NetworkCallback
import com.brixham.admity.viewmodels.DownloadViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import java.util.*


class DownloadsGridAdapter(
    private var downloadList: ArrayList<DownloadResponseData>,
    private var downloadViewModel: DownloadViewModel) :
    RecyclerView.Adapter<DownloadsGridAdapter.DownloadViewHolder>(), NetworkCallback<Any?> {

    private lateinit var view : View
    private lateinit var broadcastReceiver: BroadcastReceiver
    private lateinit var downloadImageView: ImageView

    //var Date: String? = null
    class DownloadViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var downloadTitle : TextView = itemView.findViewById(R.id.dowload_title)
        var downloadDetails : TextView = itemView.findViewById(R.id.download_details)
        var downloadImg : ImageView = itemView.findViewById(R.id.download_image)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DownloadViewHolder {
        view = LayoutInflater.from(parent.context).inflate(
            R.layout.download_layout_list,
            parent,
            false
        )




        return DownloadViewHolder(view)

    }

    override fun onBindViewHolder(holder: DownloadViewHolder, position: Int) {
        holder.downloadTitle.text = downloadList[position].download_Name
        holder.downloadDetails.text = downloadList[position].download_Desc
        /*holder.downloadTitle.text = titles[position]
        holder.downloadDetails.text = details[position]*/
        holder.downloadImg.setOnClickListener {
            downloadFile(downloadList[position].download_Url)
        }
    }

    private fun downloadFile(downloadUrl : String) {
        Log.e("DOWNLOAD", "downloadFile: $downloadUrl")
        CoroutineScope(Dispatchers.IO).launch {
            downloadViewModel.downloadFile(downloadUrl = downloadUrl, this@DownloadsGridAdapter)
        }
    }


    override fun getItemCount(): Int {
        return downloadList.size
    }

    override fun callStarted() {
        CoroutineScope(Dispatchers.Main).launch {
            Log.d("Download", "callStarted: Downloading...")
        }
    }

    override fun callFailed(errorMessage: String) {
        CoroutineScope(Dispatchers.Main).launch {
            Log.d("Download", "callFailed: $errorMessage")
        }
    }

    override fun callSuccess(data: Any) {
        CoroutineScope(Dispatchers.Main).launch {
            Log.d("Download", "callSuccess: ${data.toString()}")
        }
    }


    //Check if internet is present or not





}