package com.brixham.admity.repositories

import android.util.Log
import com.brixham.admity.models.DownloadResponseModel
import com.brixham.admity.network.ApiService
import com.brixham.admity.network.ResponseException
import com.brixham.admity.network.Result
import okhttp3.ResponseBody
import retrofit2.Response
import java.io.IOException

class DownloadRepositoryImpl(private val apiService : ApiService) : DownloadRepository {
    override suspend fun getDownloads(authToken: String): Result<DownloadResponseModel> {
        return try {
            val headerMap : HashMap<String, String> = HashMap()
//            headerMap.set(key = "A-Token", value = authToken)
            headerMap.set(key = "A-Token", value = "dTrg6L0Zzn42HhVvBPD8XlFTtbp5I5ik46")
            val downloadResponseModel: DownloadResponseModel = apiService.getDownloads(headers = headerMap).await()
            Log.d("Downloads", "getDownloads: ${downloadResponseModel.toString()}")
            Result.Success(downloadResponseModel)
        }
        catch (ex : ResponseException){
            ex.printStackTrace()
            Result.Error(IOException(ex.errorMessage))
        }
    }

    override suspend fun downloadFile(downloadUrl: String): Result<Response<ResponseBody>> {
        return try{
            val responseBody : Response<ResponseBody> = apiService.downloadFileWithDynamicUrlSync(downloadUrl).await()
            Result.Success(responseBody)
        } catch (ex : Exception){
            ex.printStackTrace()
            Result.Error(IOException("Could not download"))
        }
    }


}