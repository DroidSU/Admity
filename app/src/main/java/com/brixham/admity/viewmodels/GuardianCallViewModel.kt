package com.brixham.admity.viewmodels

import androidx.lifecycle.ViewModel
import com.brixham.admity.network.NetworkCallback
import com.brixham.admity.network.Result
import com.brixham.admity.repositories.DownloadRepository
import com.brixham.admity.repositories.GuardianCallRepository

class GuardianCallViewModel(private val guardianCallRepository: GuardianCallRepository) : ViewModel() {
    suspend fun getGuardiancall(authToken : String, networkCallback: NetworkCallback<Any?>){
        networkCallback.callStarted()
        val response = guardianCallRepository.getGuardiancall(authToken = authToken)

        if (response is Result.Success<*>){
            networkCallback.callSuccess(response.data)
        }
        else if (response is Result.Error){
            networkCallback.callFailed(response.exception.message!!)
        }
    }
}