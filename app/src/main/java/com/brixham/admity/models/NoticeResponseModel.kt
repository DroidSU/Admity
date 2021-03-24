package com.brixham.admity.models

data class NoticeResponseModel(
    val data: List<NoticeResponseData>,
    val message: String,
    val status: Boolean
)