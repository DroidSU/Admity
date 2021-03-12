package com.brixham.admity.repositories

import com.brixham.admity.models.ChangePasswordResponseModel
import com.brixham.admity.network.Result

interface ChangePasswordRepository {
    suspend fun changepwdUser(authToken : String, oldPassword : String, newPassword : String): Result<ChangePasswordResponseModel>
}