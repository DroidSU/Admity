package com.brixham.admity.viewmodels

import androidx.lifecycle.ViewModel
import com.brixham.admity.network.NetworkCallback
import com.brixham.admity.network.Result
import com.brixham.admity.repositories.MyProspectusRepository
import com.brixham.admity.repositories.NoticeRepository

class NoticeViewModel(private val noticeRepository: NoticeRepository) : ViewModel() {
    suspend fun getNotice(authToken : String, networkCallback: NetworkCallback){
        networkCallback.callStarted()
        val response = noticeRepository.getNotice(authToken = authToken)

        if (response is Result.Success<*>){
            networkCallback.callSuccess(response.data)
        }
        else if (response is Result.Error){
            networkCallback.callFailed(response.exception.message!!)
        }
    }
}