package com.brixham.admity.repositories

import android.util.Log
import com.brixham.admity.models.MyProspectusModel
import com.brixham.admity.models.NotificationsResponseModel
import com.brixham.admity.network.ApiService
import com.brixham.admity.network.ResponseException
import com.brixham.admity.network.Result
import java.io.IOException

class MyProspectusRepositoryImpl(private val apiService : ApiService) : MyProspectusRepository {
    override suspend fun getProspectus(authToken: String): Result<MyProspectusModel> {
        return try {
            val headerMap : HashMap<String, String> = HashMap()
//            headerMap.set(key = "A-Token", value = authToken)
            headerMap.set(key = "A-Token", value = "dTrg6L0Zzn42HhVvBPD8XlFTtbp5I5ik46")
            val myProspectusModel: MyProspectusModel = apiService.getProspectus(headers = headerMap).await()
            Log.d("Prospectus", "getProspectus: ${myProspectusModel.toString()}")
            Result.Success(myProspectusModel)
        }
        catch (ex : ResponseException){
            ex.printStackTrace()
            Result.Error(IOException(ex.errorMessage))
        }
    }


}