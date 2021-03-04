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
            var body : HashMap<String, String> = HashMap()
            body.set(key = "Userid", value = userId)
            body.set(key = "Password", value = password)
            body.set(key = "Fcmtoken", value = fcmToken)
            val searchData = apiService.loginUser(body = body).await()
            Result.Success(searchData)
        }
        catch (ex : ResponseException){
            ex.printStackTrace()
            Result.Error(IOException(ex.errorMessage))
        }
    }
}