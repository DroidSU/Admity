package com.brixham.admity.viewmodels

import androidx.lifecycle.ViewModel
import com.brixham.admity.network.NetworkCallback
import com.brixham.admity.network.Result
import com.brixham.admity.repositories.InstituteProfileRepository
import com.brixham.admity.repositories.StudentProfileDataRepository

class InstituteProfileViewModel(private val instituteProfileRepository: InstituteProfileRepository) : ViewModel(){
    suspend fun getInstituteProfile(authToken : String, networkCallback: NetworkCallback<Any?>){
        networkCallback.callStarted()
        val response = instituteProfileRepository.getInstituteProfile(authToken = authToken)

        if (response is Result.Success<*>){
            networkCallback.callSuccess(response.data)
        }
        else if (response is Result.Error){
            networkCallback.callFailed(response.exception.message!!)
        }
    }
}