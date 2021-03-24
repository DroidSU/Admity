package com.brixham.admity.repositories

import com.brixham.admity.models.MyProspectusModel
import com.brixham.admity.models.NotificationsResponseModel
import com.brixham.admity.network.Result

interface MyProspectusRepository {
    suspend fun getProspectus(authToken : String) : Result<MyProspectusModel>
}