package com.brixham.admity.repositories

import android.util.Log
import com.brixham.admity.models.GuardianCallModel
import com.brixham.admity.models.GuardianMeetingModel
import com.brixham.admity.network.ApiService
import com.brixham.admity.network.ResponseException
import com.brixham.admity.network.Result
import java.io.IOException

class GuardianMeetingRepositoryImpl(private val apiService : ApiService) : GuardianMeetingRepository {
    override suspend fun getGuardianmeeting(authToken: String): Result<GuardianMeetingModel> {
        return try {
            val headerMap : HashMap<String, String> = HashMap()
//            headerMap.set(key = "A-Token", value = authToken)
            headerMap.set(key = "A-Token", value = "dTrg6L0Zzn42HhVvBPD8XlFTtbp5I5ik46")
            val guardianMeetingModel: GuardianMeetingModel = apiService.getGuardianmeeting(headers = headerMap).await()
            Log.d("GuardianMeeting", "getGuardianmeeting: ${guardianMeetingModel.toString()}")
            Result.Success(guardianMeetingModel)
        }
        catch (ex : ResponseException){
            ex.printStackTrace()
            Result.Error(IOException(ex.errorMessage))
        }
    }


}