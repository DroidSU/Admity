package com.brixham.admity.models

data class NotificationsResponseModel(
    val data: ArrayList<NotificationsResponseData>,
    val message: String,
    val status: Boolean
)