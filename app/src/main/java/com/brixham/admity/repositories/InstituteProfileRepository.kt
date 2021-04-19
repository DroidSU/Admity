package com.brixham.admity.repositories

import com.brixham.admity.models.InstituteProfileModel
import com.brixham.admity.models.StudentProfileResponseModel
import com.brixham.admity.network.Result

interface InstituteProfileRepository {
    suspend fun getInstituteProfile(authToken: String): Result<InstituteProfileModel>
}