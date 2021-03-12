package com.brixham.admity.viewmodels

import androidx.lifecycle.ViewModel
import com.brixham.admity.network.NetworkCallback
import com.brixham.admity.network.Result
import com.brixham.admity.repositories.StudentProfileDataRepository

class StudentProfileViewModel(private val studentprofileRepository: StudentProfileDataRepository) : ViewModel(){
    suspend fun studentprofileUser(email: String,
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
                                   s_BloodGp: String, networkCallback: NetworkCallback){
        networkCallback.callStarted()
        val studentprofileResponse = studentprofileRepository.studentprofileUser(email = email, insId = insId,mobile = mobile, name = name,profileimage = profileimage, studentID = studentID,userid = userid, s_fName = s_fName,s_lName = s_lName,s_ContactNo = s_ContactNo, s_Email = s_Email,gender = gender,s_dob = s_dob, nationality = nationality,mstatus = mstatus, religion = religion, s_BloodGp = s_BloodGp)

        if (studentprofileResponse is Result.Success<*>){
            networkCallback.callSuccess(studentprofileResponse.data)
        }
        else if (studentprofileResponse is Result.Error){
            networkCallback.callFailed(studentprofileResponse.exception.message!!)
        }
    }
}