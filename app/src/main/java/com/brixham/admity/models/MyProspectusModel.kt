package com.brixham.admity.models

import com.brixham.admity.models.MyPropectusData

data class MyProspectusModel(
    val data: List<MyPropectusData>,
    val message: String,
    val status: Boolean
)