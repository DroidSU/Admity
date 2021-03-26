package com.brixham.admity.viewmodels

import androidx.lifecycle.ViewModel
import com.brixham.admity.network.NetworkCallback
import com.brixham.admity.network.Result
import com.brixham.admity.repositories.LoginRepository

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel(){
    suspend fun loginUser(userId : String, password : String, fcmToken : String, networkCallback: NetworkCallback<Any?>){
        networkCallback.callStarted()
        val loginResponse = loginRepository.loginUser(userId = userId, password = password, fcmToken = fcmToken)

        if (loginResponse is Result.Success<*>){
            networkCallback.callSuccess(loginResponse.data)
        }
        else if (loginResponse is Result.Error){
            networkCallback.callFailed(loginResponse.exception.message!!)
        }
    }
}