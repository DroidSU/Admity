package com.brixham.admity.repositories

import android.util.Log
import com.brixham.admity.models.InstituteProfileModel
import com.brixham.admity.models.StudentProfileResponseModel
import com.brixham.admity.network.ApiService
import com.brixham.admity.network.ResponseException
import com.brixham.admity.network.Result
import java.io.IOException

class InstituteProfileRepositoryImpl(private val apiService: ApiService) : InstituteProfileRepository {
    override suspend fun getInstituteProfile(authToken: String): Result<InstituteProfileModel> {
        return try {
            val headerMap : HashMap<String, String> = HashMap()
            //headerMap.set(key = "A-Token", value = authToken)
            headerMap.set(key = "A-Token", value = "dTrg6L0Zzn42HhVvBPD8XlFTtbp5I5ik46")
            val instituteProfileModel: InstituteProfileModel = apiService.getInstituteProfile(headers = headerMap).await()

            Log.d("Institute Profile", "instituteprofileUser: ${instituteProfileModel.toString()}")

            Result.Success(instituteProfileModel)
        }
        catch (ex : ResponseException){
            ex.printStackTrace()
            Result.Error(IOException(ex.errorMessage))
        }
    }


}