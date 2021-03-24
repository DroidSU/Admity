package com.brixham.admity.repositories

import com.brixham.admity.models.FAQResponseModel
import com.brixham.admity.models.NoticeResponseModel
import com.brixham.admity.network.Result

interface FaqRepository {
    suspend fun getFaq(authToken : String) : Result<FAQResponseModel>
}