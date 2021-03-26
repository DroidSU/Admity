package com.brixham.admity.viewmodels

import androidx.lifecycle.ViewModel
import com.brixham.admity.network.NetworkCallback
import com.brixham.admity.network.Result
import com.brixham.admity.repositories.MyProspectusRepository
import com.brixham.admity.repositories.NotificationsRepository

class MyProspectusViewModel(private val myProspectusRepository: MyProspectusRepository) : ViewModel() {
    suspend fun getProspectus(authToken : String, networkCallback: NetworkCallback<Any?>){
        networkCallback.callStarted()
        val response = myProspectusRepository.getProspectus(authToken = authToken)

        if (response is Result.Success<*>){
            networkCallback.callSuccess(response.data)
        }
        else if (response is Result.Error){
            networkCallback.callFailed(response.exception.message!!)
        }
    }
}