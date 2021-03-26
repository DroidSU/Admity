package com.brixham.admity.repositories

import com.brixham.admity.models.DownloadResponseModel
import com.brixham.admity.models.GuardianCallModel
import com.brixham.admity.network.Result

interface GuardianCallRepository {
    suspend fun getGuardiancall(authToken : String) : Result<GuardianCallModel>
}