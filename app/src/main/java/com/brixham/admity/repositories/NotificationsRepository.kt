package com.brixham.admity.repositories

import com.brixham.admity.models.NotificationsResponseModel
import com.brixham.admity.network.Result

interface NotificationsRepository {
    suspend fun getNotifications(authToken : String) : Result<NotificationsResponseModel>
}