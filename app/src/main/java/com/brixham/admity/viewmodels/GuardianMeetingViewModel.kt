package com.brixham.admity.viewmodels

import androidx.lifecycle.ViewModel
import com.brixham.admity.network.NetworkCallback
import com.brixham.admity.network.Result
import com.brixham.admity.repositories.GuardianCallRepository
import com.brixham.admity.repositories.GuardianMeetingRepository

class GuardianMeetingViewModel(private val guardianMeetingRepository: GuardianMeetingRepository) : ViewModel() {
    suspend fun getGuardianmeeting(authToken : String, networkCallback: NetworkCallback<Any?>){
        networkCallback.callStarted()
        val response = guardianMeetingRepository.getGuardianmeeting(authToken = authToken)

        if (response is Result.Success<*>){
            networkCallback.callSuccess(response.data)
        }
        else if (response is Result.Error){
            networkCallback.callFailed(response.exception.message!!)
        }
    }
}