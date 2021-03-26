package com.brixham.admity.viewmodels

import androidx.lifecycle.ViewModel
import com.brixham.admity.network.NetworkCallback
import com.brixham.admity.network.Result
import com.brixham.admity.repositories.FaqRepository
import com.brixham.admity.repositories.NoticeRepository

class FaqViewModel(private val faqRepository: FaqRepository) : ViewModel() {
    suspend fun getFaq(authToken : String, networkCallback: NetworkCallback<Any?>){
        networkCallback.callStarted()
        val response = faqRepository.getFaq(authToken = authToken)

        if (response is Result.Success<*>){
            networkCallback.callSuccess(response.data)
        }
        else if (response is Result.Error){
            networkCallback.callFailed(response.exception.message!!)
        }
    }
}