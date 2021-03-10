package com.brixham.admity.repositories

import com.brixham.admity.models.ChangePasswordResponseModel
import com.brixham.admity.network.Result

interface ChangePasswordRepository {
    suspend fun changepwdUser(oldPassword : String, newPassword : String): Result<ChangePasswordResponseModel>
}