package com.brixham.admity.repositories

import android.util.Log
import com.brixham.admity.models.DownloadResponseModel
import com.brixham.admity.models.GuardianCallModel
import com.brixham.admity.network.ApiService
import com.brixham.admity.network.ResponseException
import com.brixham.admity.network.Result
import java.io.IOException

class GuardianCallRepositoryImpl(private val apiService : ApiService) : GuardianCallRepository {
    override suspend fun getGuardiancall(authToken: String): Result<GuardianCallModel> {
        return try {
            val headerMap : HashMap<String, String> = HashMap()
//            headerMap.set(key = "A-Token", value = authToken)
            headerMap.set(key = "A-Token", value = "dTrg6L0Zzn42HhVvBPD8XlFTtbp5I5ik46")
            val guardianCallModel: GuardianCallModel = apiService.getGuardiancall(headers = headerMap).await()
            Log.d("GuardianCall", "getGuardiancall: ${guardianCallModel.toString()}")
            Result.Success(guardianCallModel)
        }
        catch (ex : ResponseException){
            ex.printStackTrace()
            Result.Error(IOException(ex.errorMessage))
        }
    }


}