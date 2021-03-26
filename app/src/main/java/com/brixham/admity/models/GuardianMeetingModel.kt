package com.brixham.admity.models

data class GuardianMeetingModel(
    val data: List<GuardianMeetingData>,
    val message: String,
    val status: Boolean
)