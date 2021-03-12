package com.brixham.admity.repositories

import com.brixham.admity.models.StudentProfileResponseModel
import com.brixham.admity.network.Result
import com.google.gson.reflect.TypeToken

interface StudentProfileDataRepository {
    suspend fun getStudentProfile(authToken: String): Result<StudentProfileResponseModel>
}