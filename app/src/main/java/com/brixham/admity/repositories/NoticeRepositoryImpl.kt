package com.brixham.admity.repositories

import android.util.Log
import com.brixham.admity.models.MyProspectusModel
import com.brixham.admity.models.NoticeResponseModel
import com.brixham.admity.network.ApiService
import com.brixham.admity.network.ResponseException
import com.brixham.admity.network.Result
import java.io.IOException

class NoticeRepositoryImpl(private val apiService : ApiService) : NoticeRepository {
    override suspend fun getNotice(authToken: String): Result<NoticeResponseModel> {
        return try {
            val headerMap : HashMap<String, String> = HashMap()
//            headerMap.set(key = "A-Token", value = authToken)
            headerMap.set(key = "A-Token", value = "dTrg6L0Zzn42HhVvBPD8XlFTtbp5I5ik46")
            val noticeResponseModel: NoticeResponseModel = apiService.getNotice(headers = headerMap).await()
            Log.d("Prospectus", "getProspectus: ${noticeResponseModel.toString()}")
            Result.Success(noticeResponseModel)
        }
        catch (ex : ResponseException){
            ex.printStackTrace()
            Result.Error(IOException(ex.errorMessage))
        }
    }


}