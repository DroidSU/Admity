package com.brixham.admity.viewmodels

import androidx.lifecycle.ViewModel
import com.brixham.admity.network.NetworkCallback
import com.brixham.admity.network.Result
import com.brixham.admity.repositories.ChangePasswordRepository
import com.brixham.admity.repositories.LoginRepository

class ChangePasswordViewModel(private val changepwdRepository: ChangePasswordRepository) : ViewModel(){
    suspend fun changepwdUser(authToken : String, oldPassword : String, newPassword : String, networkCallback: NetworkCallback){
        networkCallback.callStarted()
        val loginResponse = changepwdRepository.changepwdUser(oldPassword = oldPassword, newPassword = newPassword, authToken = authToken)

        if (loginResponse is Result.Success<*>){
            networkCallback.callSuccess(loginResponse.data)
        }
        else if (loginResponse is Result.Error){
            networkCallback.callFailed(loginResponse.exception.message!!)
        }
    }
}