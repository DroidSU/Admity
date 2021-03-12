package com.brixham.admity.repositories

import com.brixham.admity.models.ChangePasswordResponseModel
import com.brixham.admity.models.StudentProfileResponseModel
import com.brixham.admity.network.Result

interface StudentProfileDataRepository {
    suspend fun studentprofileUser( email: String,
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
                                    s_BloodGp: String): Result<StudentProfileResponseModel>
}