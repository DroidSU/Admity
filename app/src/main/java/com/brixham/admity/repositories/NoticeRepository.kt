package com.brixham.admity.repositories

import com.brixham.admity.models.MyProspectusModel
import com.brixham.admity.models.NoticeResponseModel
import com.brixham.admity.network.Result

interface NoticeRepository {
    suspend fun getNotice(authToken : String) : Result<NoticeResponseModel>
}