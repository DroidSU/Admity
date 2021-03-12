package com.brixham.admity.viewmodels

import androidx.lifecycle.ViewModel
import com.brixham.admity.models.StudentProfileResponseModel
import com.brixham.admity.network.NetworkCallback
import com.brixham.admity.network.Result
import com.brixham.admity.repositories.StudentProfileDataRepository

class StudentProfileViewModel(private val studentProfileDataRepository: StudentProfileDataRepository) : ViewModel(){
    suspend fun getStudentProfile(authToken : String, networkCallback: NetworkCallback){
        networkCallback.callStarted()
        val response = studentProfileDataRepository.getStudentProfile(authToken = authToken)

        if (response is Result.Success<*>){
            networkCallback.callSuccess(response.data)
        }
        else if (response is Result.Error){
            networkCallback.callFailed(response.exception.message!!)
        }
    }
}