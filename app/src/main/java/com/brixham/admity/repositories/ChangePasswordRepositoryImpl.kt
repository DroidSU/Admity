package com.brixham.admity.repositories

import com.brixham.admity.models.ChangePasswordResponseModel
import com.brixham.admity.network.ApiService
import com.brixham.admity.network.ResponseException
import com.brixham.admity.network.Result
import java.io.IOException

class ChangePasswordRepositoryImpl(private val apiService: ApiService) : ChangePasswordRepository {

    override suspend fun changepwdUser(
        oldPassword: String,
        newPassword: String,

    ): Result<ChangePasswordResponseModel> {
        return try {
            val body : HashMap<String, String> = HashMap()
            body.set(key = "Oldpassword", value = oldPassword)
            body.set(key = "Newpassword", value = newPassword)


            val searchData = apiService.changepwdUser(body = body).await()
            Result.Success(searchData)
        }
        catch (ex : ResponseException){
            ex.printStackTrace()
            Result.Error(IOException(ex.errorMessage))
        }
    }

}