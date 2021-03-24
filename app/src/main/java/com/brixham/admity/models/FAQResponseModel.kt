package com.brixham.admity.models

import com.brixham.admity.models.FAQResponseData

data class FAQResponseModel(
    val data: List<FAQResponseData>,
    val message: String,
    val status: Boolean
)