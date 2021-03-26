package com.brixham.admity.repositories

import com.brixham.admity.models.GuardianCallModel
import com.brixham.admity.models.GuardianMeetingModel
import com.brixham.admity.network.Result

interface GuardianMeetingRepository {
    suspend fun getGuardianmeeting(authToken : String) : Result<GuardianMeetingModel>
}