package com.brixham.admity.models

data class LoginResponseModel(
    val data: LoginResponseData,
    val message: String,
    val status: Boolean
)