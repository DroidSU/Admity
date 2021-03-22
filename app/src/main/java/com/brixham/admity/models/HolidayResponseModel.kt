package com.brixham.admity.models

data class HolidayResponseModel(
    val data: List<HolidayResponseData>,
    val message: String,
    val status: Boolean
)