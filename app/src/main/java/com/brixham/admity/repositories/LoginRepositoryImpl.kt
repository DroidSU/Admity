package com.brixham.admity.repositories

import com.brixham.admity.models.LoginResponseModel
import com.brixham.admity.network.ApiService
import com.brixham.admity.network.ResponseException
import com.brixham.admity.network.Result
import java.io.IOException

class LoginRepositoryImpl(private val apiService: ApiService) : LoginRepository{
    override suspend fun loginUser(
        userId: String,
        password: String,
        fcmToken: String
    ): Result<LoginResponseModel> {
        return try {
            val searchData = apiService.loginUser(userId = userId, password = password, fcmToken = fcmToken).await()
            Result.Success(searchData)
        }
        catch (ex : ResponseException){
            ex.printStackTrace()
            Result.Error(IOException(ex.errorMessage))
        }
    }
}