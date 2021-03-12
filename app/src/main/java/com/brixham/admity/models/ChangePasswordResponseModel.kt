package com.brixham.admity.models

data class ChangePasswordResponseModel (
    val data: ChangePasswordResponseData,
    val message: String,
    val status: Boolean
)