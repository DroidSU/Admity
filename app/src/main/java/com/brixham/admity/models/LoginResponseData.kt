package com.brixham.admity.models

data class LoginResponseData(
    val email: String,
    val insId: String,
    val mobile: String,
    val name: String,
    val profileimage: String,
    val studentID: String,
    val userid: String
)