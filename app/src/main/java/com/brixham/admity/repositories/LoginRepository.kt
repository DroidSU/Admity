package com.brixham.admity.repositories

import com.brixham.admity.models.LoginResponseModel
import com.brixham.admity.network.Result

interface LoginRepository {
    suspend fun loginUser(userId : String, password : String, fcmToken : String): Result<LoginResponseModel>
}