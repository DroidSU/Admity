package com.brixham.admity.models

import com.brixham.admity.models.GuardianCallData

data class GuardianCallModel(
    val data: List<GuardianCallData>,
    val message: String,
    val status: Boolean
)