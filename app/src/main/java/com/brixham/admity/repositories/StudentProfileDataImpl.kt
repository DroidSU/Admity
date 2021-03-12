package com.brixham.admity.repositories

import com.brixham.admity.models.ChangePasswordResponseModel
import com.brixham.admity.models.StudentProfileResponseModel
import com.brixham.admity.network.ApiService
import com.brixham.admity.network.ResponseException
import com.brixham.admity.network.Result
import java.io.IOException

class StudentProfileDataImpl(private val apiService: ApiService) : StudentProfileDataRepository {

    override suspend fun studentprofileUser(
        email: String,
        insId: String,
        mobile: String,
        name: String,
        profileimage: String,
        studentID: String,
        userid: String,
        s_fName: String,
        s_lName: String,
        s_ContactNo: String,
        s_Email: String,
        gender: String,
        s_dob: String,
        nationality: String,
        mstatus: String,
        religion: String,
        s_BloodGp: String

        ): Result<StudentProfileResponseModel> {
        return try {
            val body : HashMap<String, String> = HashMap()
            body.set(key = "email", value = email)
            body.set(key = "insId", value = insId)
            body.set(key = "mobile", value = mobile)
            body.set(key = "name", value = name)
            body.set(key = "profileimage", value = profileimage)
            body.set(key = "userid", value = userid)
            body.set(key = "s_fName", value = s_fName)
            body.set(key = "s_lName", value = s_lName)
            body.set(key = "s_ContactNo", value = s_ContactNo)
            body.set(key = "s_Email", value = s_Email)
            body.set(key = "gender", value = gender)
            body.set(key = "nationality", value = nationality)
            body.set(key = "mstatus", value = mstatus)
            body.set(key = "religion", value = religion)
            body.set(key = "s_BloodGp", value = s_BloodGp)


            val searchData: StudentProfileResponseModel = apiService.studentprofileUser(body = body).await()

            Result.Success(searchData)
        }
        catch (ex : ResponseException){
            ex.printStackTrace()
            Result.Error(IOException(ex.errorMessage))
        }
    }
}