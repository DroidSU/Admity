package com.brixham.admity.models

data class DownloadResponseModel(
    val data: List<DownloadResponseData>,
    val message: String,
    val status: Boolean
)