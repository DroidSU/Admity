package com.brixham.admity.repositories

import android.util.Log
import com.brixham.admity.models.FAQResponseModel
import com.brixham.admity.models.NoticeResponseModel
import com.brixham.admity.network.ApiService
import com.brixham.admity.network.ResponseException
import com.brixham.admity.network.Result
import java.io.IOException

class FaqRepositoryImpl(private val apiService : ApiService) : FaqRepository {
    override suspend fun getFaq(authToken: String): Result<FAQResponseModel> {
        return try {
            val headerMap : HashMap<String, String> = HashMap()
//            headerMap.set(key = "A-Token", value = authToken)
            headerMap.set(key = "A-Token", value = "dTrg6L0Zzn42HhVvBPD8XlFTtbp5I5ik46")
            val faqResponseModel: FAQResponseModel = apiService.getFaq(headers = headerMap).await()
            Log.d("FAQ", "getFaq: ${faqResponseModel.toString()}")
            Result.Success(faqResponseModel)
        }
        catch (ex : ResponseException){
            ex.printStackTrace()
            Result.Error(IOException(ex.errorMessage))
        }
    }


}