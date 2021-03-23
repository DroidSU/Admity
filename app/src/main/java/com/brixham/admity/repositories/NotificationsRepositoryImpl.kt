package com.brixham.admity.repositories

import android.util.Log
import com.brixham.admity.models.HolidayResponseModel
import com.brixham.admity.models.NotificationsResponseModel
import com.brixham.admity.network.ApiService
import com.brixham.admity.network.ResponseException
import com.brixham.admity.network.Result
import java.io.IOException

class NotificationsRepositoryImpl(private val apiService : ApiService) : NotificationsRepository {
    override suspend fun getNotifications(authToken: String): Result<NotificationsResponseModel> {
        return try {
            val headerMap : HashMap<String, String> = HashMap()
//            headerMap.set(key = "A-Token", value = authToken)
            headerMap.set(key = "A-Token", value = "dTrg6L0Zzn42HhVvBPD8XlFTtbp5I5ik46")
            val notificationsData: NotificationsResponseModel = apiService.getNotifications(headers = headerMap).await()
            Log.d("Notifications", "getNotifications: ${notificationsData.toString()}")
            Result.Success(notificationsData)
        }
        catch (ex : ResponseException){
            ex.printStackTrace()
            Result.Error(IOException(ex.errorMessage))
        }
    }
}