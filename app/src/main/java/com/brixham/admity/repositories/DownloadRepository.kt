package com.brixham.admity.repositories

import com.brixham.admity.models.DownloadResponseModel
import com.brixham.admity.network.Result
import okhttp3.ResponseBody
import retrofit2.Response

interface DownloadRepository {
    suspend fun getDownloads(authToken : String) : Result<DownloadResponseModel>

    suspend fun downloadFile(downloadUrl : String) : Result<Response<ResponseBody>>?
}