package com.brixham.admity.repositories

import android.util.Log
import com.brixham.admity.models.StudentProfileResponseModel
import com.brixham.admity.network.ApiService
import com.brixham.admity.network.ResponseException
import com.brixham.admity.network.Result
import java.io.IOException

class StudentProfileRepositoryImpl(private val apiService: ApiService) : StudentProfileDataRepository {

    override suspend fun getStudentProfile(authToken: String): Result<StudentProfileResponseModel> {
        return try {
            val headerMap : HashMap<String, String> = HashMap()
            headerMap.set(key = "A-Token", value = authToken)

            val searchData: StudentProfileResponseModel = apiService.getStudentProfile(headers = headerMap).await()

            Log.d("Student Profile", "studentprofileUser: ${searchData.toString()}")

            Result.Success(searchData)
        }
        catch (ex : ResponseException){
            ex.printStackTrace()
            Result.Error(IOException(ex.errorMessage))
        }
    }


}