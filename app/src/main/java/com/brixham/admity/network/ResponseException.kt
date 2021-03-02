package com.brixham.admity.network

import java.io.IOException

data class ResponseException(val errorCode: Int, val errorMessage: String) : IOException()