package com.brixham.admity.network

interface NetworkCallback {
    fun callStarted()
    fun callFailed(errorMessage:String)
    fun callSuccess(data: Any)
}