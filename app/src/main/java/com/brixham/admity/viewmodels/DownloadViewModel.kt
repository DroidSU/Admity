package com.brixham.admity.viewmodels

import androidx.lifecycle.ViewModel
import com.brixham.admity.network.NetworkCallback
import com.brixham.admity.network.Result
import com.brixham.admity.repositories.DownloadRepository
import com.brixham.admity.repositories.FaqRepository

class DownloadViewModel(private val downloadRepository: DownloadRepository) : ViewModel() {
    suspend fun getDownloads(authToken : String, networkCallback: NetworkCallback<Any?>){
        networkCallback.callStarted()
        val response = downloadRepository.getDownloads(authToken = authToken)

        if (response is Result.Success<*>){
            networkCallback.callSuccess(response.data)
        }
        else if (response is Result.Error){
            networkCallback.callFailed(response.exception.message!!)
        }
    }

    suspend fun downloadFile(downloadUrl : String, networkCallback: NetworkCallback<Any?>){
        networkCallback.callStarted()
        val response = downloadRepository.downloadFile(downloadUrl)
        if(response is Result.Success){
            networkCallback.callSuccess(response.data)
        }
        else if(response is Result.Error){
            networkCallback.callFailed(response.exception.message!!)
        }
    }
}