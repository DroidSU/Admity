package com.brixham.admity.viewmodels

import androidx.lifecycle.ViewModel
import com.brixham.admity.network.NetworkCallback
import com.brixham.admity.network.Result
import com.brixham.admity.repositories.HolidayRepository

class HolidayViewModel(private val holidayRepository: HolidayRepository) : ViewModel() {
    suspend fun getHoliday(authToken : String, networkCallback: NetworkCallback){
        networkCallback.callStarted()
        val response = holidayRepository.getHoliday(authToken = authToken)

        if (response is Result.Success<*>){
            networkCallback.callSuccess(response.data)
        }
        else if (response is Result.Error){
            networkCallback.callFailed(response.exception.message!!)
        }
    }
}