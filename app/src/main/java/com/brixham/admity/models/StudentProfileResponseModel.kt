package com.brixham.admity.models

data class StudentProfileResponseModel(
    val data: StudentProfileResponseData,
    val message: String,
    val status: Boolean
)
