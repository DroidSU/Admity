package com.brixham.admity.network

import com.brixham.admity.viewmodels.StudentProfileViewModel
import com.brixham.admity.views.StudentProfile

interface NetworkCallback {
    fun callStarted()
    fun callFailed(errorMessage:String)
    fun callSuccess(data: Any)

}