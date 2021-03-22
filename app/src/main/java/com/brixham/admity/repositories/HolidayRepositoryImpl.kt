package com.brixham.admity.repositories

import android.util.Log
import com.brixham.admity.models.HolidayResponseModel
import com.brixham.admity.models.StudentProfileResponseModel
import com.brixham.admity.network.ApiService
import com.brixham.admity.network.ResponseException
import com.brixham.admity.network.Result
import java.io.IOException

class HolidayRepositoryImpl(private val apiService: ApiService) : HolidayRepository {
    override suspend fun getHoliday(authToken: String): Result<HolidayResponseModel> {
        return try {
            val headerMap : HashMap<String, String> = HashMap()
            headerMap.set(key = "A-Token", value = authToken)
            val searchData: HolidayResponseModel = apiService.getHoliday(headers = headerMap).await()
            Log.d("Holiday", "holidayUser: ${searchData.toString()}")
            Result.Success(searchData)
        }
        catch (ex : ResponseException){
            ex.printStackTrace()
            Result.Error(IOException(ex.errorMessage))
        }
    }
}